package main.dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import main.po.BillPO;

/**
 * @author zhuding
 *
 */
public interface ReceivingDataService {
        public void insertBill(BillPO bill) throws RemoteException;
}
