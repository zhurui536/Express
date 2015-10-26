package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.DeliveryBLService;
import main.po.GoodsPO;

/**
 * @author zhuding
 *
 */
public class DeliveryBLService_Stub implements DeliveryBLService{

        public DeliveryBLService_Stub() {
        }
        
        @Override
        public ResultMessage addRecMessage(String Recipients, long id, long time) {
                GoodsPO goodsPO = new GoodsPO(0000000000,"核弹", "南京","北京" ,3, 40, PackageType.COURIER_BAG, ExpressType.EXPRESS);
                goodsPO.setRecipient(Recipients);
                goodsPO.setTime(time);
                System.out.println(goodsPO.getRecipient());
                System.out.println(goodsPO.getTime());
                return new ResultMessage("success", null);
        }

        @Override
        public void endDelivery() {
                System.out.println("Success!");
        }

}
