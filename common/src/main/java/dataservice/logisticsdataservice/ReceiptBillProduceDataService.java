package dataservice.logisticsdataservice;

import po.logisticpo.ReceiptBillPO;
import util.ResultMessage;
import util.Time;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * @author zhuding
 *
 */
public interface ReceiptBillProduceDataService extends Remote{
        public ResultMessage findGoods(Time time) throws RemoteException;
        
        public ResultMessage insert(ReceiptBillPO receiptBillPO)  throws RemoteException;
}
