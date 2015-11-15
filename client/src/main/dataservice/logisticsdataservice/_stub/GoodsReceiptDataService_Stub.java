package main.dataservice.logisticsdataservice._stub;

import java.rmi.RemoteException;

import main.bussinesslogic.util.BillType;
import main.dataservice.logisticsdataservice.GoodsReceiptDataService;
import main.po.BillPO;

/**
 * @author zhuding
 *
 */
public class GoodsReceiptDataService_Stub implements GoodsReceiptDataService {

        @Override
        public BillPO findBill(long id) throws RemoteException {
                // TODO Auto-generated method stub
                return new BillPO("0000", BillType.TRANSIT, "zhuding");
        }

        @Override
        public void insertBill(BillPO bill) throws RemoteException {
                System.out.println("insert successfully");
        }



}
