package dataservice.logisticsdataservice;

import po.logisticpo.LoadingBillPO;
import po.logisticpo.TransferBillPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GoodsLoadDataService extends Remote{

        public ResultMessage insertBill(LoadingBillPO bill) throws RemoteException;
        
        public ResultMessage insertBill(TransferBillPO bill) throws RemoteException;
        
}
