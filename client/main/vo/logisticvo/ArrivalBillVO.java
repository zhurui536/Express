package main.vo.logisticvo;

import main.bussinesslogic.util.GoodsState;

public class ArrivalBillVO {
        // 录入机构
        public String institution;
        // 到达日期
        public String date;
        // 中转单编号
        public String transferBillNum;
        // 出发地
        public String departurePlace;
        // 货物到达状态（损坏、完整、丢失）
        public GoodsState goodsState;
}
