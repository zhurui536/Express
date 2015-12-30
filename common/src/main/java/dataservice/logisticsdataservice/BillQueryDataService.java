package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.logisticpo.SendBillPO;

/**
 * @author zhuding
 */
public interface BillQueryDataService extends Remote{
        public SendBillPO findBill(String id) throws RemoteException ;
}
