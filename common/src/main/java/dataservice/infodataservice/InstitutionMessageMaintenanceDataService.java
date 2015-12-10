package dataservice.infodataservice;

import po.InstitutionMessagePO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author zhuding
 *
 */
public interface InstitutionMessageMaintenanceDataService extends Remote{
        public ResultMessage find(String id) throws RemoteException;
        public ResultMessage insert(InstitutionMessagePO message) throws RemoteException;
        public ResultMessage delete(String id) throws RemoteException;
        public ResultMessage update(InstitutionMessagePO message) throws RemoteException;
}
