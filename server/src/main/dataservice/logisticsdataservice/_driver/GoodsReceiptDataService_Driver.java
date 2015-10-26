package main.dataservice.logisticsdataservice._driver;

import java.rmi.RemoteException;

import main.dataservice.logisticsdataservice.GoodsReceiptDataService;
import main.dataservice.logisticsdataservice._stub.GoodsReceiptDataService_Stub;
import main.po.BillPO;

/**
 * @author zhuding
 *
 */
public class GoodsReceiptDataService_Driver {
        
      private GoodsReceiptDataService goodsReceiptDataService;
      
      public GoodsReceiptDataService_Driver(GoodsReceiptDataService goodsReceiptDataService) {
              this.goodsReceiptDataService =  goodsReceiptDataService;
      }
      
      public void drive() {
                BillPO billPO = null;
                try {
                        billPO = goodsReceiptDataService.findBill(00000);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                System.out.println(billPO.getBillType());
                try {
                        goodsReceiptDataService.insertBill(billPO);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
      }
      
      public static void main(String[] args) {
              GoodsReceiptDataService goodsReceiptDataService = new GoodsReceiptDataService_Stub();
              GoodsReceiptDataService_Driver goodsReceiptDataService_Driver = new GoodsReceiptDataService_Driver(goodsReceiptDataService);
              goodsReceiptDataService_Driver.drive();
      }
}
