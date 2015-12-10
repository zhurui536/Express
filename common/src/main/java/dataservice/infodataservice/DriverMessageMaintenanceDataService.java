package dataservice.infodataservice;

import po.DriverMessagePO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author zhuding
 */
public interface DriverMessageMaintenanceDataService extends Remote{
        public ResultMessage find(String id) throws RemoteException;
        public ResultMessage insert(DriverMessagePO message) throws RemoteException;
        public ResultMessage delete(String id) throws RemoteException;
        public ResultMessage update(DriverMessagePO message) throws RemoteException;

}
