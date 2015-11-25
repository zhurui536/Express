package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.BillPO;

/**
 * @author zhuding
 *
 */
public interface BillQueryDataService {
        public BillPO findBill(String id) throws RemoteException ;
}
