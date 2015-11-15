package main.dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import main.po.BillPO;

public interface GoodsLoadDataService {

        public BillPO findBill(long id) throws RemoteException;
        
        public void insertBill(BillPO bill) throws RemoteException;
        
}
