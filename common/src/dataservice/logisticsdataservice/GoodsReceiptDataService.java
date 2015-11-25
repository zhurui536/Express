package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.BillPO;

/**
 * @author zhuding
 *
 */
public interface GoodsReceiptDataService {
        
        public BillPO findBill(long id) throws RemoteException;
        
        public void insertBill(BillPO bill) throws RemoteException;
        

}
