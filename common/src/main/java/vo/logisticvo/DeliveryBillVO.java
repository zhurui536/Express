package vo.logisticvo;

import java.util.ArrayList;

import po.logisticpo.DeliveryBillPO;
import util.Time;


public class DeliveryBillVO {
        // 到达日期
        public Time time;
        // 托运订单条形码号
        public ArrayList<String> ids;
        // 派送员
        public String deliverManId;
        
        public DeliveryBillVO(DeliveryBillPO po){
        	this.time = po.getTime();
        	this.ids = po.getIds();
        	this.deliverManId = po.getDeliverManId();
        }
        public DeliveryBillVO(){
        	
        }
}
