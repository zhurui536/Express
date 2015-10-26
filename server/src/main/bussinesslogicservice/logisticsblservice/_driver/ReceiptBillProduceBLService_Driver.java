package main.bussinesslogicservice.logisticsblservice._driver;

import main.bussinesslogicservice.logisticsblservice.ReceiptBillProduceBLService;
import main.bussinesslogicservice.logisticsblservice._stub.ReceiptBillProduceBLService_Stub;
import main.vo.BillVO;

/**
 * @author zhuding
 *
 */
public class ReceiptBillProduceBLService_Driver {
        
        private ReceiptBillProduceBLService receiptBillProduceBLService ;
        
        public ReceiptBillProduceBLService_Driver(ReceiptBillProduceBLService receiptBillProduceBLService) {
                this.receiptBillProduceBLService =  receiptBillProduceBLService;
        }
        
        public void drive() {
                BillVO billVO = (BillVO)receiptBillProduceBLService.produceReceiptBill().getValue();
                System.out.println(billVO.getBillType());
                
        }
        
        public static void main(String[] args) {
                ReceiptBillProduceBLService receiptBillProduceBLService = new ReceiptBillProduceBLService_Stub();
                ReceiptBillProduceBLService_Driver receiptBillProduceBLService_Driver = new ReceiptBillProduceBLService_Driver(receiptBillProduceBLService);
                receiptBillProduceBLService_Driver.drive();
        }
}
