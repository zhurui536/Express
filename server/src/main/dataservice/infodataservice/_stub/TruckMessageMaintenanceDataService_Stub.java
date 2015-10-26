package main.dataservice.infodataservice._stub;

import java.rmi.RemoteException;

import main.dataservice.infodataservice.TruckMessageMaintenanceDataService;
import main.po.TruckMessagePO;

/**
 * @author zhuding
 *
 */
public class TruckMessageMaintenanceDataService_Stub implements TruckMessageMaintenanceDataService{
        @Override
        public TruckMessagePO find(long id) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("find it");
                return new TruckMessagePO();
        }

        @Override
        public void insert(TruckMessagePO message) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("insert successfully");
        }

        @Override
        public void delete(long id) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("delete successfully");
        }

        @Override
        public void update(TruckMessagePO message) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("update successfully");
        }
}
