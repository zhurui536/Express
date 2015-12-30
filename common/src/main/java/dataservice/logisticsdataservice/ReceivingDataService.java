package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.logisticpo.SendBillPO;
import util.ResultMessage;

/**
 * @author zhuding
 */
public interface ReceivingDataService extends Remote{
        
        public ResultMessage insertBill(SendBillPO bill) throws RemoteException;
        
        public ResultMessage findAll() throws RemoteException;
}
