package main.bussinesslogicservice.logisticsblservice._driver;

import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;
import main.bussinesslogicservice.logisticsblservice.ReceivingBLService;
import main.bussinesslogicservice.logisticsblservice._stub.ReceivingBLService_Stub;
import main.vo.BillVO;
import main.vo.GoodsVO;

/**
 * @author zhuding
 *
 */
public class ReceivingBLService_Driver {
        
        private ReceivingBLService receivingBLService;
        
         public static void main(String[] args) {
                ReceivingBLService receivingBLService = new ReceivingBLService_Stub();
                ReceivingBLService_Driver receivingBLService_Driver = new ReceivingBLService_Driver(receivingBLService);
                receivingBLService_Driver.drive();
        }
         
         public ReceivingBLService_Driver(ReceivingBLService receivingBLService) {
                this.receivingBLService = receivingBLService;
        }
         
         public void drive() {
                BillVO billVO = new BillVO("00000",BillType.SEND);
//                System.out.println(receivingBLService.addMessage(billVO).getKey());
//                GoodsVO goodsVO = new GoodsVO(0000000000,"核弹", "南京","北京" ,3, 40, PackageType.COURIER_BAG, ExpressType.EXPRESS);
//                System.out.println(receivingBLService.getCharge(goodsVO));
                receivingBLService.getTime();
                receivingBLService.endReceipt();
                
        }
}
