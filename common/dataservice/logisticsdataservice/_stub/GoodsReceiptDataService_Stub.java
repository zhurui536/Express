package dataservice.logisticsdataservice._stub;

import java.rmi.RemoteException;

import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;

import dataservice.logisticsdataservice.GoodsReceiptDataService;
import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;

/**
 * @author zhuding
 *
 */
public class GoodsReceiptDataService_Stub implements GoodsReceiptDataService {

        @Override
        public ResultMessage findBill(String id) throws RemoteException {
                // TODO Auto-generated method stub
//                return new BillPO("0000", BillType.TRANSIT, "zhuding");
                return null;
        }

        @Override
        public ResultMessage insertBill(DeliveryBillPO bill) throws RemoteException {
                System.out.println("insert successfully");
                return null;
        }

        @Override
        public ResultMessage insertBill(ArrivalBillPO bill)
                        throws RemoteException {
                // TODO Auto-generated method stub
                return null;
        }



}
