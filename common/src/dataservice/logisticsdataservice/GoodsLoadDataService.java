package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.BillPO;

public interface GoodsLoadDataService {

        public BillPO findBill(long id) throws RemoteException;
        
        public void insertBill(BillPO bill) throws RemoteException;
        
}
