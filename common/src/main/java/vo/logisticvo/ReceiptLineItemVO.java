package vo.logisticvo;

import java.math.BigDecimal;

public class ReceiptLineItemVO {
        public String deliveryManID;

        public String barCode;

        public BigDecimal money;

        public ReceiptLineItemVO(String deliveryManID, String barCode,
                        BigDecimal money) {
                super();
                this.deliveryManID = deliveryManID;
                this.barCode = barCode;
                this.money = money;
        }

		public String getDeliveryManID() {
			return deliveryManID;
		}

		public String getBarCode() {
			return barCode;
		}

		public BigDecimal getMoney() {
			return money;
		}
        
        
        
}
