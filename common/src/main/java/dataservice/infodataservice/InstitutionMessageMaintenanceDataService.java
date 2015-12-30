package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.InstitutionMessagePO;
import util.ResultMessage;

/**
 * @author zhuding
 *
 */
public interface InstitutionMessageMaintenanceDataService extends Remote{
        public ResultMessage find(String id) throws RemoteException;
        public ResultMessage insert(InstitutionMessagePO message) throws RemoteException;
        public ResultMessage delete(String id) throws RemoteException;
        public ResultMessage update(InstitutionMessagePO message) throws RemoteException;
        public ResultMessage get() throws RemoteException;
}
