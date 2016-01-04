package po.logisticpo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import po.BillPO;
import util.BillType;
import util.Time;
import vo.logisticvo.ReceiptBillVO;
import vo.logisticvo.ReceiptLineItemVO;

/**
 * 收款单PO 2015/12/6
 */

public class ReceiptBillPO extends BillPO {

        private static final long serialVersionUID = 1526637956814486761L;

        private Time time;

        private BigDecimal totalMoney;

        private String institutionID;

        private List<ReceiptLineItemPO> receiptLineItemPOs;
        
        private String billID;
        
        private String staffID;
        
        // 是否被结算过
        private boolean isSettled;
        
        public ReceiptBillPO(Time time, BigDecimal totalMoney,
                        String institutionID,
                        List<ReceiptLineItemPO> receiptLineItemPOs, String billID, String staffID) {
                super(BillType.RECEIPT, staffID);
                this.time = time;
                this.totalMoney = totalMoney;
                this.institutionID = institutionID;
                this.receiptLineItemPOs = receiptLineItemPOs;
                this.billID = billID;
                this.staffID = staffID;
                this.isSettled = false;
        }
        
        public ReceiptBillVO poToVo() {
                List<ReceiptLineItemVO> receiptLineItemVOs = new ArrayList<>();
                for (ReceiptLineItemPO receiptLineItemPO : receiptLineItemPOs) {
                        receiptLineItemVOs.add(receiptLineItemPO.poToVo());
                }
                return new ReceiptBillVO(time, totalMoney, institutionID, receiptLineItemVOs);
        }

        public Time getTime() {
                return time;
        }

        public void setTime(Time time) {
                this.time = time;
        }

        public BigDecimal getTotalMoney() {
                return totalMoney;
        }

        public void setTotalMoney(BigDecimal totalMoney) {
                this.totalMoney = totalMoney;
        }

        public String getInstitutionID() {
                return institutionID;
        }

        public void setInstitutionID(String institutionID) {
                this.institutionID = institutionID;
        }

        public List<ReceiptLineItemPO> getReceiptLineItemPOs() {
                return receiptLineItemPOs;
        }


        public void setReceiptLineItemPOs(
                        List<ReceiptLineItemPO> receiptLineItemPOs) {
                this.receiptLineItemPOs = receiptLineItemPOs;
        }

        public String getUser(){
    		return this.staffID;
    	}
    	
    	public String getBill(){
    		return this.billID;
    	}

		public boolean isSettled() {
			return isSettled;
		}

		public void setSettled(boolean isSettled) {
			this.isSettled = isSettled;
		}

}
