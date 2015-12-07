package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;

import po.DriverMessagePO;

/**
 * @author zhuding
 */
public interface DriverMessageMaintenanceDataService extends Remote{
        public ResultMessage find(String id) throws RemoteException;
        public ResultMessage insert(DriverMessagePO message) throws RemoteException;
        public ResultMessage delete(String id) throws RemoteException;
        public ResultMessage update(DriverMessagePO message) throws RemoteException;

}
