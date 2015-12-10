package vo.logisticvo;

import util.Time;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by Away
 * 2015/12/6
 */

public class ReceiptBillVO {

        public Time time;

        public BigDecimal totalMoney;

        public String institutionID;

        public List<ReceiptLineItemVO> receiptLineItemVOs;

        public ReceiptBillVO(Time time, BigDecimal totalMoney,
                        String institutionID,
                        List<ReceiptLineItemVO> receiptLineItemVOs) {
                super();
                this.time = time;
                this.totalMoney = totalMoney;
                this.institutionID = institutionID;
                this.receiptLineItemVOs = receiptLineItemVOs;
        }
        
        
}
