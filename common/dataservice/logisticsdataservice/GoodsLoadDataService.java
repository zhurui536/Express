package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;

import po.logisticpo.LoadingBillPO;
import po.logisticpo.TransferBillPO;

public interface GoodsLoadDataService {

        public ResultMessage findBill(long id) throws RemoteException;
        
        public ResultMessage insertBill(LoadingBillPO bill) throws RemoteException;
        
        public ResultMessage insertBill(TransferBillPO bill) throws RemoteException;
        
}
