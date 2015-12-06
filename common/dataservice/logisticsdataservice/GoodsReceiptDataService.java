package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;

import main.bussinesslogic.util.ResultMessage;


/**
 * @author zhuding
 */
public interface GoodsReceiptDataService {
        
        public ResultMessage findBill(String id) throws RemoteException;
        
        public ResultMessage insertBill(ArrivalBillPO bill) throws RemoteException;
        
        public ResultMessage insertBill(DeliveryBillPO bill) throws RemoteException;
}
