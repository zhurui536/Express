package main.data.infodata;

import dataservice.infodataservice.StaffMessageMaintenanceDataService;
import main.dao.Database;
import po.StaffMessagePO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StaffMessageMaintenanceDataServiceImpl extends UnicastRemoteObject implements StaffMessageMaintenanceDataService{

        private static final long serialVersionUID = 1709425729832465611L;
        
//        private static final String PATH = "server/src/main/java/save/infodata/staffMessagePO.dat";
        private static final String PATH = "src/main/java/save/infodata/staffMessagePO.dat";
        
        private ArrayList<StaffMessagePO> staffMessagePOs;

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
                        staffMessagePOs.add(message);
                        Database.save(PATH, staffMessagePOs);
                        return new ResultMessage("SUCCESS");
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
                        staffMessagePOs.remove(resultMessage.getValue());
                        staffMessagePOs.add(message);
                        Database.save(PATH, staffMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("NO_EXIST");
        }

		@Override
		public ResultMessage getStaff() throws RemoteException {
			return new ResultMessage("SUCCESS", this.staffMessagePOs);
		}

}
