package dataservice.logisticsdataservice._driver;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.ReceivingDataService;
import dataservice.logisticsdataservice._stub.ReceivingDataService_Stub;
import main.bussinesslogic.util.BillType;
import po.BillPO;

/**
 * @author zhuding
 *
 */
public class ReceivingDataService_Driver {
        private ReceivingDataService receivingDataService;
        
        public ReceivingDataService_Driver(ReceivingDataService receivingDataService) {
                this.receivingDataService = receivingDataService;
        }
        
        public void drive(){
                try {
                        receivingDataService.insertBill(new BillPO("00000", BillType.SEND, "zhuding"));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
        
        public static void main(String[] args) {
                ReceivingDataService receivingDataService = new ReceivingDataService_Stub();
                ReceivingDataService_Driver receivingDataService_Driver = new ReceivingDataService_Driver(receivingDataService);
                receivingDataService_Driver.drive();
        }
}
