package data.infodata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.infodataservice.DriverMessageMaintenanceDataService;
import po.DriverMessagePO;
import serialutility.Database;
import util.ResultMessage;

public class DriverMessageMaintenanceDataServiceImpl extends UnicastRemoteObject implements DriverMessageMaintenanceDataService{

        private static final long serialVersionUID = 2363428936751059509L;
        
        private static final String PATH = "save/infodata/driverMessagePO.dat";
        
        private ArrayList<DriverMessagePO> driverMessagePOs;

        public DriverMessageMaintenanceDataServiceImpl()
                        throws RemoteException {
                super();
                init();
        }
        
        @SuppressWarnings("unchecked")
        private void init(){
                driverMessagePOs = (ArrayList<DriverMessagePO>) Database.load(PATH);
                if(driverMessagePOs == null)
                        driverMessagePOs = new ArrayList<>();
        }

        @Override
        public ResultMessage find(String id) throws RemoteException {
                init();
                for (DriverMessagePO driverMessagePO : driverMessagePOs) {
                        if(driverMessagePO.getDriverId().equals(id))
                                return new ResultMessage("FOUND",driverMessagePO);
                }
                return new ResultMessage("NO_EXIST");
        }

        @Override
        public ResultMessage insert(DriverMessagePO message)
                        throws RemoteException {
                ResultMessage resultMessage = find(message.getDriverId());
                if(resultMessage.getKey().equals("NO_EXIST")){
                        driverMessagePOs.add(message);
                        Database.save(PATH, driverMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("EXIST");
                
        }

        @Override
        public ResultMessage delete(String id) throws RemoteException {
                ResultMessage resultMessage = find(id);
                if(resultMessage.getKey().equals("FOUND")){
                        driverMessagePOs.remove(resultMessage.getValue());
                        Database.save(PATH, driverMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("NO_EXIST");
        }

        @Override
        public ResultMessage update(DriverMessagePO message)
                        throws RemoteException {
                ResultMessage resultMessage = find(message.getDriverId());
                if(resultMessage.getKey().equals("FOUND")){
                        driverMessagePOs.remove(resultMessage.getValue());
                        driverMessagePOs.add(message);
                        Database.save(PATH, driverMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("NO_EXIST");
        }

        @Override
        public ResultMessage findAll(String institutionID) throws RemoteException{
                init();
                ArrayList<DriverMessagePO> driverMessagePOs = new ArrayList<DriverMessagePO>();
                for (DriverMessagePO driverMessagePO : this.driverMessagePOs) {
                        if(driverMessagePO.getInstitutionID().equals(institutionID))
                                driverMessagePOs.add(driverMessagePO);
                }
                return new ResultMessage("success",driverMessagePOs);
        }

}
