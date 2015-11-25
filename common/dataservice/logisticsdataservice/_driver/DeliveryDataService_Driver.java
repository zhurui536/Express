package dataservice.logisticsdataservice._driver;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.DeliveryDataService;
import dataservice.logisticsdataservice._stub.DeliveryDataService_Stub;
import po.GoodsPO;

/**
 * @author zhuding
 *
 */
public class DeliveryDataService_Driver {
        
        private DeliveryDataService deliveryDataService;
        
        public DeliveryDataService_Driver(DeliveryDataService deliveryDataService) {
               this.deliveryDataService = deliveryDataService;
        }
        
        public static void main(String[] args) {
                DeliveryDataService deliveryDataService = new DeliveryDataService_Stub();
                DeliveryDataService_Driver dataService_Driver = new DeliveryDataService_Driver(deliveryDataService);
                dataService_Driver.drive();
        }
        
        public void drive() {
                GoodsPO goodsPO = null;
                try {
                        goodsPO = deliveryDataService.findGoods(000000);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                goodsPO.setRecipient("NULL");
                goodsPO.setTime(10);
                try {
                        deliveryDataService.updateGoods(goodsPO);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
        }
        
}
