package main.dataservice.infodataservice;

import java.rmi.RemoteException;

import main.po.StaffMessagePO;

/**
 * @author zhuding
 *
 */
public interface StaffMessageMaintenanceDataService {
        public StaffMessagePO find(long id) throws RemoteException;
        public void insert(StaffMessagePO message) throws RemoteException;
        public void delete(long id) throws RemoteException;
        public void update(StaffMessagePO message) throws RemoteException;
}
