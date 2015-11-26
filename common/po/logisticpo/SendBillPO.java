package po.logisticpo;

import java.io.Serializable;

import main.vo.logisticvo.SendBillVO;

import po.GoodsPO;

@SuppressWarnings("serial")
public class SendBillPO implements Serializable{
        //寄件人信息
        private PeopleMessagePO senderPO;
        //收件人信息
        private PeopleMessagePO recipientPO;
        //托运货物信息
        private GoodsPO goodsPO;
        //订单条形码号
        private String id;
        
        public SendBillPO(PeopleMessagePO senderPO,
                        PeopleMessagePO recipientPO, GoodsPO goodsPO, String id) {
                super();
                this.senderPO = senderPO;
                this.recipientPO = recipientPO;
                this.goodsPO = goodsPO;
                this.id = id;
        }
        
        public SendBillVO poToVo() {
                SendBillVO sendBillVO = new SendBillVO();
                
                sendBillVO.goodsVO = this.goodsPO.poToVo();
                sendBillVO.id = this.id;
                sendBillVO.recipientVO = this.recipientPO.poToVo();
                sendBillVO.senderVO = this.senderPO.poToVo();
                
                return sendBillVO;
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
