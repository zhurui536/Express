package main.vo.logisticvo;

import java.util.ArrayList;

import main.bussinesslogic.util.Time;

public class DeliveryBillVO {
        // 到达日期
        public Time time;
        // 托运订单条形码号
        public ArrayList<String> ids;
        // 派送员
        public String deliverManId;
}
