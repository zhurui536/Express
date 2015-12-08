package dataservice.logisticsdataservice._stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;

import dataservice.logisticsdataservice.ReceivingDataService;
import po.logisticpo.SendBillPO;

/**
 * @author zhuding
 *
 */
public class ReceivingDataService_Stub implements ReceivingDataService {

        @Override
        public ResultMessage insertBill(SendBillPO bill) throws RemoteException {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public ResultMessage findAll() throws RemoteException {
                // TODO Auto-generated method stub
                return null;
        }


        
}
