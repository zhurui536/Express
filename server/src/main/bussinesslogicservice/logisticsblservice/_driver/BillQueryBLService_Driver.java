package main.bussinesslogicservice.logisticsblservice._driver;

import main.bussinesslogicservice.logisticsblservice.BillQueryBLService;
import main.bussinesslogicservice.logisticsblservice._stub.BillQueryBLService_Stub;
import main.dataservice.logisticsdataservice.BillQueryDataService;
import main.dataservice.logisticsdataservice._stub.BillQueryDataService_Stub;

/**
 * @author zhuding
 *
 */
public class BillQueryBLService_Driver {
        
        private BillQueryBLService billQueryBLService;
        
        public static void main(String[] args) {
                BillQueryDataService billQueryDataService = new BillQueryDataService_Stub();
                BillQueryBLService billQueryBLService = new BillQueryBLService_Stub(billQueryDataService);
                BillQueryBLService_Driver billQueryBLService_Driver = new BillQueryBLService_Driver(billQueryBLService);
                billQueryBLService_Driver.drive();
        }
        
        public BillQueryBLService_Driver(BillQueryBLService billQueryBLService) {
                this.billQueryBLService = billQueryBLService;
        }
        
        public void drive() {
                billQueryBLService.queryBill(0000000001);
                billQueryBLService.endQueryBill();
        }
        
}
