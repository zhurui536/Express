package main.data.infodata;


//github.com/awayz/Express.git
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.infodataservice.StaffMessageMaintenanceDataService;
import main.dao.Database;
import po.StaffMessagePO;
import util.ResultMessage;

public class StaffMessageMaintenanceDataServiceImpl extends UnicastRemoteObject implements StaffMessageMaintenanceDataService{

        private static final long serialVersionUID = 1709425729832465611L;
        
        private static final String PATH = "src/main/java/save/infodata/staffMessagePO.dat";
        
        private ArrayList<StaffMessagePO> staffMessagePOs;
        private InstitutionMessageMaintenanceDataServiceImpl instdata;

        public StaffMessageMaintenanceDataServiceImpl()
                        throws RemoteException {
                super();
                init();
        }
        
        @SuppressWarnings("unchecked")
        private void init(){
                staffMessagePOs = (ArrayList<StaffMessagePO>) Database.load(PATH);
                if(staffMessagePOs == null)
                        staffMessagePOs = new ArrayList<>();
                
                try {
					instdata = new InstitutionMessageMaintenanceDataServiceImpl();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
        }


        @Override
        public ResultMessage find(String id) throws RemoteException {
                for (StaffMessagePO staffMessagePO : staffMessagePOs) {
                        if(staffMessagePO.getId().equals(id))
                                return new ResultMessage("FOUND",staffMessagePO);
                }
                return new ResultMessage("NO_EXIST");
        }

        @Override
        public ResultMessage insert(StaffMessagePO message)
                        throws RemoteException {
                ResultMessage resultMessage = find(message.getId());
                if(resultMessage.getKey().equals("NO_EXIST")){
                	resultMessage = instdata.find(message.getInstitutionid());
                	if(resultMessage.getKey().equals("FOUND")){
                        staffMessagePOs.add(message);
                        Database.save(PATH, staffMessagePOs);
                        return new ResultMessage("SUCCESS");
                	}
                	else{//否则返回提示机构不存在
                		return new ResultMessage("noinstitution");
                	}
                }
                return new ResultMessage("EXIST");
        }

        @Override
        public ResultMessage delete(String id) throws RemoteException {
                ResultMessage resultMessage = find(id);
                if(resultMessage.getKey().equals("FOUND")){
                        staffMessagePOs.remove(resultMessage.getValue());
                        Database.save(PATH, staffMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("NO_EXIST");
        }

        @Override
        public ResultMessage update(StaffMessagePO message)
                        throws RemoteException {
                ResultMessage resultMessage = find(message.getId());
                if(resultMessage.getKey().equals("FOUND")){
                	//查找到对应的id之后检查机构id
                	resultMessage = instdata.find(message.getInstitutionid());
                	if(resultMessage.getKey().equals("FOUND")){
                		staffMessagePOs.remove(resultMessage.getValue());
                        staffMessagePOs.add(message);
                        Database.save(PATH, staffMessagePOs);
                        return new ResultMessage("SUCCESS");
                	}
                	else{//否则返回提示机构不存在
                		return new ResultMessage("noinstitution");
                	}
                }
                return new ResultMessage("NO_EXIST");
        }

		@Override
		public ResultMessage getStaff() throws RemoteException {
			return new ResultMessage("SUCCESS", this.staffMessagePOs);
		}
		
		public ResultMessage delInstitution(String instid){
			for(int i=0;i<this.staffMessagePOs.size();i++){
				if(this.staffMessagePOs.get(i).getInstitutionid().equals(instid)){
					//如果有员工的机构被删除，则将机构id改为默认值
					this.staffMessagePOs.get(i).setInstitutionid("admin");
				}
			}
			Database.save(PATH, staffMessagePOs);
			return new ResultMessage("SUCCESS");
		}
}
