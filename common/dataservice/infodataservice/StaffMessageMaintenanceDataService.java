package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StaffMessagePO;

/**
 * @author zhuding
 *
 */
public interface StaffMessageMaintenanceDataService extends Remote{
        public StaffMessagePO find(long id) throws RemoteException;
        public void insert(StaffMessagePO message) throws RemoteException;
        public void delete(long id) throws RemoteException;
        public void update(StaffMessagePO message) throws RemoteException;
}
