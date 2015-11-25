package dataservice.logisticsdataservice._stub;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.ReceivingDataService;
import po.BillPO;

/**
 * @author zhuding
 *
 */
public class ReceivingDataService_Stub implements ReceivingDataService {

        @Override
        public void insertBill(BillPO bill) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("insert successfully");
        }
        
}
