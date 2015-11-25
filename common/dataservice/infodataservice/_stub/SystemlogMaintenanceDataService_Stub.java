package dataservice.infodataservice._stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.infodataservice.SystemlogMaintenanceDataService;
import po.SystemlogPO;

/**
 * @author zhuding
 *
 */
public class SystemlogMaintenanceDataService_Stub implements SystemlogMaintenanceDataService {

        @Override
        public ArrayList<SystemlogPO> getSystemlog() throws RemoteException {
                System.out.println("success!");
                return new ArrayList<>();
        }

        @Override
        public void insert(SystemlogPO message) throws RemoteException {
                System.out.println("insert successfully");
        }

     
}
