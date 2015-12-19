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

        public String billID;

        public String staffID;

        public ReceiptBillVO(Time time, BigDecimal totalMoney,
                        String institutionID,
                        List<ReceiptLineItemVO> receiptLineItemVOs) {
                super();
                this.time = time;
                this.totalMoney = totalMoney;
                this.institutionID = institutionID;
                this.receiptLineItemVOs = receiptLineItemVOs;
        }

		public Time getTime() {
			return time;
		}

		public BigDecimal getTotalMoney() {
			return totalMoney;
		}

		public String getInstitutionID() {
			return institutionID;
		}

		public List<ReceiptLineItemVO> getReceiptLineItemVOs() {
			return receiptLineItemVOs;
		}

		public String getBillID() {
			return billID;
		}

		public String getStaffID() {
			return staffID;
		}
        
        
}
