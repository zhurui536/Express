package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;


/**
 * @author zhuding
 *
 */
public interface ReceiptBillProduceDataService {
        public ResultMessage findGoods(Time time) throws RemoteException;
        
        public ResultMessage insert() ;
}
