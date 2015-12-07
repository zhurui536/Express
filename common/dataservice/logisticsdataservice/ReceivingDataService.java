package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.logisticpo.SendBillPO;

/**
 * @author zhuding
 */
public interface ReceivingDataService extends Remote{
        
        public void insertBill(SendBillPO bill) throws RemoteException;
        
        public ArrayList<SendBillPO> findAll() throws RemoteException;
}
