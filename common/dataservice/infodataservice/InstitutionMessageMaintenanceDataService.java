package dataservice.infodataservice;

import java.rmi.RemoteException;

import po.InstitutionMessagePO;

/**
 * @author zhuding
 *
 */
public interface InstitutionMessageMaintenanceDataService {
        public InstitutionMessagePO find(long id) throws RemoteException;
        public void insert(InstitutionMessagePO message) throws RemoteException;
        public void delete(long id) throws RemoteException;
        public void update(InstitutionMessagePO message) throws RemoteException;
}
