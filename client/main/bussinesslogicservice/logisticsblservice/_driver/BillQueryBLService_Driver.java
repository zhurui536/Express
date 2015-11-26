package main.bussinesslogicservice.logisticsblservice._driver;

import main.bussinesslogicservice.logisticsblservice.BillQueryBLService;
import main.bussinesslogicservice.logisticsblservice._stub.BillQueryBLService_Stub;


/**
 * @author zhuding
 *
 */
public class BillQueryBLService_Driver {
        
        private BillQueryBLService billQueryBLService;
        
        public static void main(String[] args) {
                BillQueryBLService billQueryBLService = new BillQueryBLService_Stub();
                BillQueryBLService_Driver billQueryBLService_Driver = new BillQueryBLService_Driver(billQueryBLService);
                billQueryBLService_Driver.drive();
        }
        
        public BillQueryBLService_Driver(BillQueryBLService billQueryBLService) {
                this.billQueryBLService = billQueryBLService;
        }
        
        public void drive() {
              // System.out.println(billQueryBLService.queryBill("0000000000").getBillType());
                billQueryBLService.endQueryBill();
        }
        
}
