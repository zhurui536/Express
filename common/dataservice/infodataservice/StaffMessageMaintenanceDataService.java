package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;

import po.StaffMessagePO;

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
