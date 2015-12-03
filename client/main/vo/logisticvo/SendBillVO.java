package main.vo.logisticvo;

import main.bussinesslogic.util.BillState;
import main.vo.GoodsVO;

public class SendBillVO {
        //寄件人信息
        public PeopleMessageVO senderVO;
        //收件人信息
        public PeopleMessageVO recipientVO;
        //托运货物信息
        public GoodsVO goodsVO;
        //订单条形码号
        public String id;
        //单据审批状态
        public BillState billState;
}
