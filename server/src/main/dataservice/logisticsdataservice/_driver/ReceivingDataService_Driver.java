package main.dataservice.logisticsdataservice._driver;

import java.rmi.RemoteException;

import main.bussinesslogic.util.BillType;
import main.dataservice.logisticsdataservice.ReceivingDataService;
import main.dataservice.logisticsdataservice._stub.ReceivingDataService_Stub;
import main.po.BillPO;

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
                        receivingDataService.insertBill(new BillPO("00000", BillType.SEND));
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
