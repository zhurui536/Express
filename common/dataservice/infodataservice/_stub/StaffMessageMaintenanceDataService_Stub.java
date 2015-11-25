package dataservice.infodataservice._stub;

import java.rmi.RemoteException;

import dataservice.infodataservice.StaffMessageMaintenanceDataService;
import po.StaffMessagePO;

/**
 * @author zhuding
 *
 */
public class StaffMessageMaintenanceDataService_Stub implements StaffMessageMaintenanceDataService {
        @Override
        public StaffMessagePO find(long id) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("find it");
                return new StaffMessagePO(null,null);
        }

        @Override
        public void insert(StaffMessagePO message) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("insert successfully");
        }

        @Override
        public void delete(long id) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("delete successfully");
        }

        @Override
        public void update(StaffMessagePO message) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("update successfully");
        }
}
