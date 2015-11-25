package dataservice.infodataservice;

import java.rmi.RemoteException;

import po.DriverMessagePO;

/**
 * @author zhuding
 *
 */
public interface DriverMessageMaintenanceDataService {
        public DriverMessagePO find(long id) throws RemoteException;
        public void insert(DriverMessagePO message) throws RemoteException;
        public void delete(long id) throws RemoteException;
        public void update(DriverMessagePO message) throws RemoteException;

}
