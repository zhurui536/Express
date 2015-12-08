package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;

import po.logisticpo.SendBillPO;

/**
 * @author zhuding
 */
public interface ReceivingDataService extends Remote{
        
        public ResultMessage insertBill(SendBillPO bill) throws RemoteException;
        
        public ResultMessage findAll() throws RemoteException;
}
