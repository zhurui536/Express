package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.logisticpo.SendBillPO;

/**
 * @author zhuding
 *
 */
public interface BillQueryDataService {
        public SendBillPO findBill(String id) throws RemoteException ;
}
