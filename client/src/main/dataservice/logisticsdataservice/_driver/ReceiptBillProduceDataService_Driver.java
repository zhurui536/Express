package main.dataservice.logisticsdataservice._driver;

import java.rmi.RemoteException;

import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;
import main.dataservice.logisticsdataservice.ReceiptBillProduceDataService;
import main.dataservice.logisticsdataservice._stub.ReceiptBillProduceDataService_Stub;
import main.po.GoodsPO;

/**
 * @author zhuding
 *
 */
public class ReceiptBillProduceDataService_Driver {
        private ReceiptBillProduceDataService receiptBillProduceDataService;
        
        public ReceiptBillProduceDataService_Driver(ReceiptBillProduceDataService receiptBillProduceDataService) {
                this.receiptBillProduceDataService = receiptBillProduceDataService;
        } 
        
        public void drive(){
                try {
                        receiptBillProduceDataService.insertGoods(new GoodsPO("0000000000","核弹", "南京","北京" ,3, 40, PackageType.COURIER_BAG, ExpressType.EXPRESS));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
        
        public static void main(String[] args) {
                ReceiptBillProduceDataService receiptBillProduceDataService = new ReceiptBillProduceDataService_Stub();
                ReceiptBillProduceDataService_Driver receiptBillProduceDataService_Driver = new ReceiptBillProduceDataService_Driver(receiptBillProduceDataService);
                receiptBillProduceDataService_Driver.drive();
        }
}
