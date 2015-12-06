package main.vo.logisticvo;

import java.util.ArrayList;

public class LoadingBillVO {
        // 录入机构
        public String institution;
        // 装车日期
        public String date;
        // 汽运编号（中转中心编号+日期+七位数字 或 营业厅编号 + 日期 + 五位数字）
        public String transferNum;
        // 到达地
        public String arrivalPlace;
        // 车辆代号
        public String numOfTruck;
        // 监装员
        public String supervisor;
        // 押运员
        public String supercargo;
        // 本次装箱所有订单条形码号
        public ArrayList<String> ids;
        // 运费
        public double charge;
}
