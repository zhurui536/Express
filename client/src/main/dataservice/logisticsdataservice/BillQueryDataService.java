package main.dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import main.po.BillPO;

/**
 * @author zhuding
 *
 */
public interface BillQueryDataService {
        public BillPO findBill(String id) throws RemoteException ;
}
