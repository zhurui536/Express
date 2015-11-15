package main.dataservice.logisticsdataservice._stub;

import java.rmi.RemoteException;

import main.bussinesslogic.util.BillType;
import main.dataservice.logisticsdataservice.BillQueryDataService;
import main.po.BillPO;

/**
 * @author zhuding
 *
 */
public class BillQueryDataService_Stub implements BillQueryDataService {

        @Override
        public BillPO findBill(String id) throws RemoteException {
                System.out.println("find it");
                return new BillPO("0000000000",BillType.SEND, "zhuding");
        }

}
