package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.BillPO;

/**
 * @author zhuding
 *
 */
public interface ReceivingDataService {
        public void insertBill(BillPO bill) throws RemoteException;
}
