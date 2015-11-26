package dataservice.logisticsdataservice._stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.logisticsdataservice.ReceivingDataService;
import po.logisticpo.SendBillPO;

/**
 * @author zhuding
 *
 */
public class ReceivingDataService_Stub implements ReceivingDataService {

        @Override
        public void insertBill(SendBillPO bill) throws RemoteException {
                // TODO Auto-generated method stub
                System.out.println("insert successfully");
        }

        @Override
        public ArrayList<SendBillPO> findAll() throws RemoteException {
                // TODO Auto-generated method stub
                return null;
        }
        
}
