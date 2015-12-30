package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StaffMessagePO;
import util.ResultMessage;

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
        public ResultMessage getStaff() throws RemoteException;
}
