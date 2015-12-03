package po.logisticpo;

import java.io.Serializable;

import main.bussinesslogic.util.BillState;
import main.vo.logisticvo.SendBillVO;

import po.GoodsPO;

@SuppressWarnings("serial")
public class SendBillPO implements Serializable {
        // 寄件人信息
        private PeopleMessagePO senderPO;
        // 收件人信息
        private PeopleMessagePO recipientPO;
        // 托运货物信息
        private GoodsPO goodsPO;
        // 订单条形码号
        private String id;
        //单据审批状态
        private BillState billState;

        public SendBillPO(PeopleMessagePO senderPO,
                        PeopleMessagePO recipientPO, GoodsPO goodsPO, String id) {
                super();
                this.senderPO = senderPO;
                this.recipientPO = recipientPO;
                this.goodsPO = goodsPO;
                this.id = id;
                this.billState = BillState.DRAFT;
        }

        public SendBillVO poToVo() {
                SendBillVO sendBillVO = new SendBillVO();

                sendBillVO.goodsVO = this.goodsPO.poToVo();
                sendBillVO.id = this.id;
                sendBillVO.recipientVO = this.recipientPO.poToVo();
                sendBillVO.senderVO = this.senderPO.poToVo();
                sendBillVO.billState = this.billState;

                return sendBillVO;
        }

        
        
        public static SendBillPO voToPo(SendBillVO sendBillVO) {
                SendBillPO sendBillPO = new SendBillPO(
                                PeopleMessagePO.voToPo(sendBillVO.senderVO),
                                PeopleMessagePO.voToPo(sendBillVO.recipientVO),
                                GoodsPO.voToPo(sendBillVO.goodsVO),
                                sendBillVO.id);
                sendBillPO.setBillState(sendBillVO.billState);
                return sendBillPO;
        }

        public BillState getBillState() {
                return billState;
        }

        public void setBillState(BillState billState) {
                this.billState = billState;
        }

        public PeopleMessagePO getSenderPO() {
                return senderPO;
        }

        public void setSenderPO(PeopleMessagePO senderPO) {
                this.senderPO = senderPO;
        }

        public PeopleMessagePO getRecipientPO() {
                return recipientPO;
        }

        public void setRecipientPO(PeopleMessagePO recipientPO) {
                this.recipientPO = recipientPO;
        }

        public GoodsPO getGoodsPO() {
                return goodsPO;
        }

        public void setGoodsPO(GoodsPO goodsPO) {
                this.goodsPO = goodsPO;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

}
