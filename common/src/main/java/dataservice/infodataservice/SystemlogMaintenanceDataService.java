package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SystemlogPO;

/**
 * @author zhuding
 *
 */
public interface SystemlogMaintenanceDataService extends Remote{
        public ArrayList<SystemlogPO> getSystemlog() throws RemoteException;
        public void insert(SystemlogPO message) throws RemoteException;
}
