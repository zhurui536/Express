package main.data.infodata;

import dataservice.infodataservice.TruckMessageMaintenanceDataService;
import main.dao.Database;
import po.TruckMessagePO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class TruckMessageMaintenanceDataServiceImpl extends UnicastRemoteObject implements TruckMessageMaintenanceDataService{

        private static final long serialVersionUID = 4360334337327289944L;

        private static final String PATH = "src/main/java/save/infodata/truckMessagePO.dat";

        private ArrayList<TruckMessagePO> truckMessagePOs;
        
        public TruckMessageMaintenanceDataServiceImpl()
                        throws RemoteException {
                super();
                init();
        }
        
        @SuppressWarnings("unchecked")
        private void init(){
                truckMessagePOs = (ArrayList<TruckMessagePO>) Database.load(PATH);
                if(truckMessagePOs == null)
                        truckMessagePOs = new ArrayList<>();
        }

        @Override
        public ResultMessage find(String id) throws RemoteException {
                for (TruckMessagePO truckMessagePO : truckMessagePOs) {
                        if(truckMessagePO.getId().equals(id))
                                return new ResultMessage("FOUND",truckMessagePO);
                }
                return new ResultMessage("NO_EXIST");
        }

        @Override
        public ResultMessage insert(TruckMessagePO message)
                        throws RemoteException {
                ResultMessage resultMessage = find(message.getId());
                if(resultMessage.getKey().equals("NO_EXIST")){
                        truckMessagePOs.add(message);
                        Database.save(PATH, truckMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("EXIST");
        }

        @Override
        public ResultMessage delete(String id) throws RemoteException {
                ResultMessage resultMessage = find(id);
                if(resultMessage.getKey().equals("FOUND")){
                        truckMessagePOs.remove(resultMessage.getValue());
                        Database.save(PATH, truckMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("NO_EXIST");
        }

        @Override
        public ResultMessage update(TruckMessagePO message)
                        throws RemoteException {
                ResultMessage resultMessage = find(message.getId());
                if(resultMessage.getKey().equals("FOUND")){
                        truckMessagePOs.remove(resultMessage.getValue());
                        truckMessagePOs.add(message);
                        Database.save(PATH, truckMessagePOs);
                        return new ResultMessage("SUCCESS");
                }
                return new ResultMessage("NO_EXIST");
        }

}
