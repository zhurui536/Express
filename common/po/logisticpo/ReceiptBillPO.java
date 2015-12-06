package po.logisticpo;

import main.bussinesslogic.util.Time;
import main.vo.logisticvo.ReceiptBillVO;
import main.vo.logisticvo.ReceiptLineItemVO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 收款单PO 2015/12/6
 */

public class ReceiptBillPO implements Serializable {

        private static final long serialVersionUID = 1526637956814486761L;

        private Time time;

        private BigDecimal totalMoney;

        private String institutionID;

        private List<ReceiptLineItemPO> receiptLineItemPOs;

        public ReceiptBillPO(Time time, BigDecimal totalMoney,
                        String institutionID,
                        List<ReceiptLineItemPO> receiptLineItemPOs) {
                super();
                this.time = time;
                this.totalMoney = totalMoney;
                this.institutionID = institutionID;
                this.receiptLineItemPOs = receiptLineItemPOs;
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





}
