package dataservice.logisticsdataservice._stub;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.BillQueryDataService;
import main.bussinesslogic.util.BillType;
import po.BillPO;
import po.logisticpo.SendBillPO;

/**
 * @author zhuding
 *
 */
public class BillQueryDataService_Stub implements BillQueryDataService {

        @Override
        public SendBillPO findBill(String id) throws RemoteException {
                System.out.println("find it");
//                return new BillPO("0000000000",BillType.SEND, "zhuding");
                return null;
        }

}
