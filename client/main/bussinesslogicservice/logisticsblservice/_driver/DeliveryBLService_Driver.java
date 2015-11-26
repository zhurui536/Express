package main.bussinesslogicservice.logisticsblservice._driver;

import main.bussinesslogicservice.logisticsblservice.DeliveryBLService;
import main.bussinesslogicservice.logisticsblservice._stub.DeliveryBLService_Stub;

/**
 * @author zhuding
 *
 */
public class DeliveryBLService_Driver {
        
        private DeliveryBLService deliveryBLService;
        
        public static void main(String[] args) {
                
                DeliveryBLService deliveryBLService = new DeliveryBLService_Stub();
                DeliveryBLService_Driver deliveryBLService_Driver = new DeliveryBLService_Driver(deliveryBLService);
                deliveryBLService_Driver.drive();
        }
        
        public DeliveryBLService_Driver(DeliveryBLService deliveryBLService) {
                this.deliveryBLService  = deliveryBLService;
        }
        
        public void drive() {
                deliveryBLService.addRecMessage("NULL", "0000000000", 10);
                deliveryBLService.endDelivery();
        }
}
