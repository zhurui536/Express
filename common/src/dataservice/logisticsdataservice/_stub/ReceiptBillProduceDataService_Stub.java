package dataservice.logisticsdataservice._stub;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.ReceiptBillProduceDataService;
import po.GoodsPO;

/**
 * @author zhuding
 *
 */
public class ReceiptBillProduceDataService_Stub implements ReceiptBillProduceDataService{

        @Override
        public void insertGoods(GoodsPO goods) throws RemoteException {
                System.out.println("insert successfully");
        }

}
