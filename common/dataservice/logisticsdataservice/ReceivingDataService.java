package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.logisticpo.SendBillPO;

/**
 * @author zhuding
 */
public interface ReceivingDataService {
        
        public void insertBill(SendBillPO bill) throws RemoteException;
        
        public ArrayList<SendBillPO> findAll() throws RemoteException;
}
