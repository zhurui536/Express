package main.bussinesslogic.financebl;

import dataservice.financedataservice.ShowReceiptDataService;
import dataservice.financedataservice.ShowStatementDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.ShowProfitListBLService;
import main.connection.ClientRMIHelper;
import main.vo.storevo.ProfitListVO;
import po.financepo.PayBillPO;
import po.logisticpo.ReceiptBillPO;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 成本收益表
 * Created by Away
 * 2015/11/15
 */

public class ShowProfitListBL implements ShowProfitListBLService {

    private ShowStatementDataService showStatementDataServiceImpl;

    private ShowReceiptDataService showReceiptDataServiceImpl;

    private ProfitListVO profitListVO;

    public ShowProfitListBL() {
        showStatementDataServiceImpl = (ShowStatementDataService) ClientRMIHelper.
                getServiceByName("ShowStatementDataServiceImpl");
        showReceiptDataServiceImpl = (ShowReceiptDataService) ClientRMIHelper.
                getServiceByName("ShowReceiptDataServiceImpl");

    }

    @Override
    public ResultMessage showProfitList() {
        try {
            ResultMessage payMsg = showStatementDataServiceImpl.findAllPayBill();
            ResultMessage receiptMsg = showReceiptDataServiceImpl.findAll();
            if (!isValidMsg(payMsg) || !isValidMsg(receiptMsg)) {
                return new ResultMessage("fail");
            }
            List<PayBillPO> payBillPOs = (List<PayBillPO>) payMsg.getValue();
            List<ReceiptBillPO> receiptBillPOs = (List<ReceiptBillPO>) receiptMsg.getValue();
            updateProfitListVO(new Time(), payBillPOs, receiptBillPOs);
            return new ResultMessage("success", profitListVO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    /**
     * 更新成本收益表 VO
     * @param time 截止时间
     * @param payBillPOs 付款单 VO
     * @param receiptBillPOs 收款单 VO
     */
    private void updateProfitListVO(Time time, List<PayBillPO> payBillPOs, List<ReceiptBillPO> receiptBillPOs) {
        BigDecimal income = BigDecimal.ZERO;
        BigDecimal pay = BigDecimal.ZERO;
        BigDecimal profit;

        for (ReceiptBillPO po : receiptBillPOs) {
            if (isValidReceiptBillPO(time, po)) {
                income = income.add(po.getTotalMoney());
            }
        }
        for (PayBillPO po : payBillPOs) {
            if (isValidPayBillPO(time, po)) {
                pay = pay.add(po.getMoney());
            }
        }

        profit = income.subtract(pay);
        profitListVO = new ProfitListVO(income, pay, profit);
    }

    @Override
    public ResultMessage profitListToExcel() {
        return null;
    }

    private boolean isValidReceiptBillPO(Time time, ReceiptBillPO po) {
        return time.compareTo(po.getTime()) >= 0;
    }

    private boolean isValidPayBillPO(Time time, PayBillPO po) {
        return time.compareTo(po.getTime()) >= 0;
    }

    private boolean isValidMsg(ResultMessage message) {
        return message.getKey().equals("success");
    }
}
