package main.bussinesslogicservice.logisticsblservice._driver;

import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.GoodsState;
import main.bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import main.bussinesslogicservice.logisticsblservice._stub.GoodsReceiptBLService_Stub;
import main.vo.BillVO;

/**
 * @author zhuding
 *
 */
public class GoodsReceiptBLService_Driver {
        
        private GoodsReceiptBLService goodsReceiptBLService;
        
        public static void main(String[] args) {
                GoodsReceiptBLService goodsReceiptBLService = new GoodsReceiptBLService_Stub();
                GoodsReceiptBLService_Driver goodsReceiptBLService_Driver = new GoodsReceiptBLService_Driver(goodsReceiptBLService);
                goodsReceiptBLService_Driver.drive();
        }
        
        public GoodsReceiptBLService_Driver(GoodsReceiptBLService goodsReceiptBLService) {
                this.goodsReceiptBLService = goodsReceiptBLService;
        }
        
        public void drive() {
                System.out.println(goodsReceiptBLService.produceArrivalBill(new BillVO("02500000", BillType.TRANSIT), GoodsState.COMPLETE).getBillType());
                
                System.out.println(goodsReceiptBLService.produceSendBill(new BillVO("02500001", BillType.ARRIVAL), 000001).getBillType());
                goodsReceiptBLService.endGoodsreceipt();
        }
}
