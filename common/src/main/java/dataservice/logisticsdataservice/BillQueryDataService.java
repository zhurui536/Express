package dataservice.logisticsdataservice;

import po.logisticpo.SendBillPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author zhuding
 */
public interface BillQueryDataService extends Remote{
        public SendBillPO findBill(String id) throws RemoteException ;
}
