package main.data.infodata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import main.dao.Database;
import po.InstitutionMessagePO;
import util.InstitutionType;
import util.ResultMessage;

public class InstitutionMessageMaintenanceDataServiceImpl extends UnicastRemoteObject implements InstitutionMessageMaintenanceDataService{

        private static final long serialVersionUID = -2566534132857071603L;
        
//        private static final String PATH = "server/src/main/java/save/infodata/institutionMessagePO.dat";
        private static final String PATH = "src/main/java/save/infodata/institutionMessagePO.dat";
        
        private ArrayList<InstitutionMessagePO> institutionMessagePOs;
        private StaffMessageMaintenanceDataServiceImpl staffdata;
        
        public InstitutionMessageMaintenanceDataServiceImpl()
                        throws RemoteException {
                super();
                init();
        }

        @SuppressWarnings("unchecked")
        private void init(){
                institutionMessagePOs = (ArrayList<InstitutionMessagePO>) Database.load(PATH);
                if(institutionMessagePOs == null){
                        institutionMessagePOs = new ArrayList<>();
                        //添加默认机构
                        institutionMessagePOs.add(new InstitutionMessagePO("默认机构", "admin", InstitutionType.BUSINESS_HALL));
                }
                
                try {
					staffdata = new StaffMessageMaintenanceDataServiceImpl();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
        }
        
        @Override
        public ResultMessage find(String id) throws RemoteException {
                for (InstitutionMessagePO institutionMessagePO : institutionMessagePOs) {
                        if(institutionMessagePO.getId().equals(id))
                                return new ResultMessage("FOUND",institutionMessagePO);
                }
                return new ResultMessage("NO_EXIST");
        }

        @Override
        public ResultMessage insert(InstitutionMessagePO message)
                        throws RemoteException {
                ResultMessage resultMessage = find(message.getId());
                if(resultMessage.getKey().equals("NO_EXIST")){
                        institutionMessagePOs.add(message);
                        Database.save(PATH, institutionMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("EXIST");
        }

        @Override
        public ResultMessage delete(String id) throws RemoteException {
                ResultMessage resultMessage = find(id);
                if(resultMessage.getKey().equals("FOUND")){
                        institutionMessagePOs.remove(resultMessage.getValue());
                        Database.save(PATH, institutionMessagePOs);
                        //将该机构下的员工的机构id设为默认值
                        staffdata.delInstitution(id);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("NO_EXIST");
        }

        @Override
        public ResultMessage update(InstitutionMessagePO message)
                        throws RemoteException {
                ResultMessage resultMessage = find(message.getId());
                if(resultMessage.getKey().equals("FOUND")){
                        institutionMessagePOs.remove(resultMessage.getValue());
                        institutionMessagePOs.add(message);
                        Database.save(PATH, institutionMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("NO_EXIST");
        }

		@Override
		public ResultMessage get() throws RemoteException {
			return new ResultMessage("SUCCESS", this.institutionMessagePOs);
		}

}
