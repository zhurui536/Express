package po.logisticpo;

import main.bussinesslogic.util.BillState;
import main.bussinesslogic.util.BillType;
import main.vo.logisticvo.SendBillVO;
import po.BillPO;
import po.GoodsPO;
/**
 * 寄件单
 * @author zhuding
 */
public class SendBillPO extends BillPO {

        private static final long serialVersionUID = -5413700054156146188L;

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
        //快递员
        private String deliveryManID;

        public SendBillPO(PeopleMessagePO senderPO,
                        PeopleMessagePO recipientPO, GoodsPO goodsPO, String id,String deliveryManID) {
                super(id, BillType.DELIVERY, deliveryManID);
                this.senderPO = senderPO;
                this.recipientPO = recipientPO;
                this.goodsPO = goodsPO;
                this.id = id;
                this.deliveryManID = deliveryManID;
                this.billState = BillState.DRAFT;
        }

        public SendBillVO poToVo() {
                SendBillVO sendBillVO = new SendBillVO();

                sendBillVO.goodsVO = this.goodsPO.poToVo();
                sendBillVO.id = this.id;
                sendBillVO.recipientVO = this.recipientPO.poToVo();
                sendBillVO.senderVO = this.senderPO.poToVo();
                sendBillVO.billState = this.billState;
                sendBillVO.deliveryManID = this.deliveryManID;
                return sendBillVO;
        }

        
        
        public static SendBillPO voToPo(SendBillVO sendBillVO) {
                SendBillPO sendBillPO = new SendBillPO(
                                PeopleMessagePO.voToPo(sendBillVO.senderVO),
                                PeopleMessagePO.voToPo(sendBillVO.recipientVO),
                                GoodsPO.voToPo(sendBillVO.goodsVO),
                                sendBillVO.id,sendBillVO.deliveryManID);
                sendBillPO.setBillState(sendBillVO.billState);
                return sendBillPO;
        }

        public String getDeliveryManID() {
                return deliveryManID;
        }

        public void setDeliveryManID(String deliveryManID) {
                this.deliveryManID = deliveryManID;
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
