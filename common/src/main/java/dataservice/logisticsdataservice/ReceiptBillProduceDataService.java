package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.logisticpo.ReceiptBillPO;
import util.ResultMessage;
import util.Time;


/**
 * @author zhuding
 *
 */
public interface ReceiptBillProduceDataService extends Remote{
        public ResultMessage findGoods(Time time) throws RemoteException;
        
        public ResultMessage insert(ReceiptBillPO receiptBillPO)  throws RemoteException;
}
