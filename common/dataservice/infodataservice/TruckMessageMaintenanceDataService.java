package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;

import po.TruckMessagePO;

/**
 * @author zhuding
 *
 */
public interface TruckMessageMaintenanceDataService extends Remote{
        public ResultMessage find(String id) throws RemoteException;
        public ResultMessage insert(TruckMessagePO message) throws RemoteException;
        public ResultMessage delete(String id) throws RemoteException;
        public ResultMessage update(TruckMessagePO message) throws RemoteException;
}
