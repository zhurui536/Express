package vo.logisticvo;

import util.Time;

import java.util.ArrayList;


public class DeliveryBillVO {
        // 到达日期
        public Time time;
        // 托运订单条形码号
        public ArrayList<String> ids;
        // 派送员
        public String deliverManId;
}