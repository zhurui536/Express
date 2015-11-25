package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.GoodsPO;

/**
 * @author zhuding
 *
 */
public interface ReceiptBillProduceDataService {
        public void insertGoods(GoodsPO goods) throws RemoteException;
}
