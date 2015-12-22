package main.data.infodata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.infodataservice.SystemlogMaintenanceDataService;
import main.dao.Database;
import po.SystemlogPO;

public class SystemlogDataServiceImpl extends UnicastRemoteObject implements SystemlogMaintenanceDataService{

        private static final long serialVersionUID = 3772837929204546971L;
        
        private static final String PATH = "src/main/java/save/infodata/systemLog.dat";
        
        private ArrayList<SystemlogPO> systemlogPOs;

        public SystemlogDataServiceImpl() throws RemoteException {
                super();
        }

        @SuppressWarnings("unchecked")
        private void read(){
                systemlogPOs = (ArrayList<SystemlogPO>) Database.load(PATH);
                if(systemlogPOs == null)
                        systemlogPOs = new ArrayList<>();
        }
        
        @Override
        public ArrayList<SystemlogPO> getSystemlog() throws RemoteException {
                read();
                return systemlogPOs;
        }

        @Override
        public void insert(SystemlogPO message) throws RemoteException {
                read();
                systemlogPOs.add(message);
                Database.save(PATH, systemlogPOs);
        }

}
