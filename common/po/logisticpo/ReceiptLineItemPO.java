package po.logisticpo;

import java.io.Serializable;
import java.math.BigDecimal;

import main.vo.logisticvo.ReceiptLineItemVO;


public class ReceiptLineItemPO implements Serializable{

        private static final long serialVersionUID = -2320886943715508476L;
        
        private String deliveryManID;
        
        private String barCode;
        
        private BigDecimal money;

        public ReceiptLineItemPO(String deliveryManID, String barCode,
                        BigDecimal money) {
                super();
                this.deliveryManID = deliveryManID;
                this.barCode = barCode;
                this.money = money;
        }

        public ReceiptLineItemVO poToVo() {
                return new ReceiptLineItemVO(deliveryManID, barCode, money);
        }
        
        public String getDeliveryManID() {
                return deliveryManID;
        }

        public void setDeliveryManID(String deliveryManID) {
                this.deliveryManID = deliveryManID;
        }

        public String getBarCode() {
                return barCode;
        }

        public void setBarCode(String barCode) {
                this.barCode = barCode;
        }

        public BigDecimal getMoney() {
                return money;
        }

        public void setMoney(BigDecimal money) {
                this.money = money;
        }
        
        

}
