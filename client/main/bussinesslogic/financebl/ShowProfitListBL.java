package main.bussinesslogic.financebl;

import dataservice.financedataservice.ShowReceiptDataService;
import dataservice.financedataservice.ShowStatementDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.ShowProfitListBLService;
import main.connection.ClientRMIHelper;
import main.vo.PayBillVO;
import main.vo.logisticvo.ReceiptBillVO;
import main.vo.storevo.ProfitListVO;

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
            List<PayBillVO> payBillVOs = (List<PayBillVO>) payMsg.getValue();
            List<ReceiptBillVO> receiptBillVOs = (List<ReceiptBillVO>) receiptMsg.getValue();
            updateProfitListVO(new Time(), payBillVOs, receiptBillVOs);
            return new ResultMessage("success", profitListVO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    /**
     * 更新成本收益表 VO
     * @param time 截止时间
     * @param payBillVOs 付款单 VO
     * @param receiptBillVOs 收款单 VO
     */
    private void updateProfitListVO(Time time, List<PayBillVO> payBillVOs, List<ReceiptBillVO> receiptBillVOs) {
        BigDecimal income = BigDecimal.ZERO;
        BigDecimal pay = BigDecimal.ZERO;
        BigDecimal profit;

        for (ReceiptBillVO vo : receiptBillVOs) {
            if (isValidReceiptBillVO(time, vo)) {
                income = income.add(vo.totalMoney);
            }
        }
        for (PayBillVO vo : payBillVOs) {
            if (isValidPayBillVO(time, vo)) {
                pay = pay.add(vo.money);
            }
        }

        profit = income.subtract(pay);
        profitListVO = new ProfitListVO(income, pay, profit);
    }

    @Override
    public ResultMessage profitListToExcel() {
        return null;
    }

    private boolean isValidReceiptBillVO(Time time, ReceiptBillVO vo) {
        return time.compareTo(vo.time) >= 0;
    }

    private boolean isValidPayBillVO(Time time, PayBillVO vo) {
        return time.compareTo(vo.time) >= 0;
    }

    private boolean isValidMsg(ResultMessage message) {
        return message.getKey().equals("success");
    }
}
