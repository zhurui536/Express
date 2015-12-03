package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.BillPO;
import po.logisticpo.LoadingBillPO;

public interface GoodsLoadDataService {

        public BillPO findBill(long id) throws RemoteException;
        
        public void insertBill(LoadingBillPO bill) throws RemoteException;
        
}
