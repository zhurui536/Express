package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.GoodsPO;
import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;

import main.bussinesslogic.util.ResultMessage;


/**
 * @author zhuding
 */
public interface GoodsReceiptDataService {
        
        public ResultMessage findBill(String id) throws RemoteException;
        
        public GoodsPO findGoods(String id) throws RemoteException;
        
        public ResultMessage updateGoods(GoodsPO goodsPO) throws RemoteException;
        
        public ResultMessage insertBill(ArrivalBillPO bill) throws RemoteException;
        
        public ResultMessage insertBill(DeliveryBillPO bill) throws RemoteException;
}
