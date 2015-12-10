package main.data.infodata;

import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import main.dao.Database;
import po.InstitutionMessagePO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class InstitutionMessageMaintenanceDataServiceImpl extends UnicastRemoteObject implements InstitutionMessageMaintenanceDataService{

        private static final long serialVersionUID = -2566534132857071603L;
        
        private static final String PATH = "server/src/main/java/save/infodata/institutionMessagePO.dat";
        
        private ArrayList<InstitutionMessagePO> institutionMessagePOs;
        
        public InstitutionMessageMaintenanceDataServiceImpl()
                        throws RemoteException {
                super();
                init();
        }

        @SuppressWarnings("unchecked")
        private void init(){
                institutionMessagePOs = (ArrayList<InstitutionMessagePO>) Database.load(PATH);
                if(institutionMessagePOs == null)
                        institutionMessagePOs = new ArrayList<>();
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

}
