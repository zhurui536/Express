package dataservice.infodataservice;

import po.StaffMessagePO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

;

/**
 * @author zhuding
 *
 */
public interface StaffMessageMaintenanceDataService extends Remote{
        public ResultMessage find(String id) throws RemoteException;
        public ResultMessage insert(StaffMessagePO message) throws RemoteException;
        public ResultMessage delete(String id) throws RemoteException;
        public ResultMessage update(StaffMessagePO message) throws RemoteException;
}
