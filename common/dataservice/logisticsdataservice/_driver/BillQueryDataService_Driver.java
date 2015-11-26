package dataservice.logisticsdataservice._driver;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.BillQueryDataService;
import dataservice.logisticsdataservice._stub.BillQueryDataService_Stub;

/**
 * @author zhuding
 *
 */
public class BillQueryDataService_Driver {
        
        private BillQueryDataService billQueryDataService;
        
        public static void main(String[] args) {
                BillQueryDataService billQueryDataService = new BillQueryDataService_Stub();
                BillQueryDataService_Driver billQueryDataService_Driver = new BillQueryDataService_Driver(billQueryDataService);
                billQueryDataService_Driver.drive();
        }
        
        public BillQueryDataService_Driver(BillQueryDataService billQueryDataService) {
                this.billQueryDataService = billQueryDataService;
        }
        
        public void drive() {
//                try {
//                        System.out.println(billQueryDataService.findBill("00000").getBillType());
//                } catch (RemoteException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                }
        }
}
