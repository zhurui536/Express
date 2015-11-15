package main.dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import main.po.GoodsPO;

/**
 * @author zhuding
 *
 */
public interface ReceiptBillProduceDataService {
        public void insertGoods(GoodsPO goods) throws RemoteException;
}
