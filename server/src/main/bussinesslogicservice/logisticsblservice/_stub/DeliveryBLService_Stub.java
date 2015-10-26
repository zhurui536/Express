package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.DeliveryBLService;
import main.dataservice.logisticsdataservice.DeliveryDataService;

/**
 * @author zhuding
 *
 */
public class DeliveryBLService_Stub implements DeliveryBLService{

        private DeliveryDataService deliveryDataService;
        
        public DeliveryBLService_Stub(DeliveryDataService deliveryDataService) {
                this.deliveryDataService = deliveryDataService;
        }
        
        @Override
        public ResultMessage addRecMessage(String Recipients, long id, long time) {
                
                return null;
        }

        @Override
        public void endDelivery() {
                System.out.println("Success!");
        }

}
