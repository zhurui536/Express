package main.dataservice.infodataservice;

import java.rmi.RemoteException;

import main.po.TruckMessagePO;

/**
 * @author zhuding
 *
 */
public interface TruckMessageMaintenanceDataService {
        public TruckMessagePO find(long id) throws RemoteException;
        public void insert(TruckMessagePO message) throws RemoteException;
        public void delete(long id) throws RemoteException;
        public void update(TruckMessagePO message) throws RemoteException;
}
