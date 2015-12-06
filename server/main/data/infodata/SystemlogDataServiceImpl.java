package main.data.infodata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SystemlogPO;
import dataservice.infodataservice.SystemlogMaintenanceDataService;

public class SystemlogDataServiceImpl implements SystemlogMaintenanceDataService{

        @Override
        public ArrayList<SystemlogPO> getSystemlog() throws RemoteException {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public void insert(SystemlogPO message) throws RemoteException {
                // TODO Auto-generated method stub
                
        }

}
