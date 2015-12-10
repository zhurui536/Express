package dataservice.infodataservice;

import po.SystemlogPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author zhuding
 *
 */
public interface SystemlogMaintenanceDataService extends Remote{
        public ArrayList<SystemlogPO> getSystemlog() throws RemoteException;
        public void insert(SystemlogPO message) throws RemoteException;
}
