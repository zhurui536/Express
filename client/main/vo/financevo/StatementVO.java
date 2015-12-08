package main.vo.financevo;

import main.vo.logisticvo.ReceiptBillVO;

import java.util.List;

/**
 * Created by Away
 * 2015/12/6
 */

public class StatementVO {

    public List<PayBillVO> payBillVOs;

    public List<ReceiptBillVO> receiptBillVOs;

    public StatementVO(List<PayBillVO> payBillVOs, List<ReceiptBillVO> receiptBillVOs) {
        this.payBillVOs = payBillVOs;
        this.receiptBillVOs = receiptBillVOs;
    }
}
