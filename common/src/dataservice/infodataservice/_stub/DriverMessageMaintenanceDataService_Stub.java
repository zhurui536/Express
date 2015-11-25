package dataservice.infodataservice._stub;

import java.rmi.RemoteException;

import dataservice.infodataservice.DriverMessageMaintenanceDataService;
import po.DriverMessagePO;

/**
 * @author zhuding
 *
 */
public class DriverMessageMaintenanceDataService_Stub implements DriverMessageMaintenanceDataService {

        @Override
        public DriverMessagePO find(long id) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("find it");
                return new DriverMessagePO();
        }

        @Override
        public void insert(DriverMessagePO message) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("insert successfully");
        }

        @Override
        public void delete(long id) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("delete successfully");
        }

        @Override
        public void update(DriverMessagePO message) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("update successfully");
        }

}
