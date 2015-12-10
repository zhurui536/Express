package dataservice.logisticsdataservice;

import po.GoodsPO;
import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * @author zhuding
 */
public interface GoodsReceiptDataService extends Remote{
        
        public ResultMessage findBill(String id) throws RemoteException;
        
        public GoodsPO findGoods(String id) throws RemoteException;
        
        public ResultMessage updateGoods(GoodsPO goodsPO) throws RemoteException;
        
        public ResultMessage insertBill(ArrivalBillPO bill) throws RemoteException;
        
        public ResultMessage insertBill(DeliveryBillPO bill) throws RemoteException;
}
