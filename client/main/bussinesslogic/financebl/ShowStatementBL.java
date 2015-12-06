package main.bussinesslogic.financebl;

import dataservice.financedataservice.ShowStatementDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.ShowStatementBLService;
import main.connection.ClientRMIHelper;
import main.vo.PayBillVO;
import main.vo.StatementVO;
import main.vo.logisticvo.ReceiptBillVO;
import po.financepo.PayBillPO;
import po.logisticpo.ReceiptBillPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * 经营情况表逻辑层实现
 * Created by Away
 * 2015/11/15
 */

public class ShowStatementBL implements ShowStatementBLService {

    private ShowStatementDataService showStatementDataServiceImpl;

    private StatementVO statementVO;

    // 导出前是否已更新过经营情况表
    private boolean isUpdated;

    public ShowStatementBL() {
        showStatementDataServiceImpl = (ShowStatementDataService) ClientRMIHelper.
                getServiceByName("ShowStatementDataServiceImpl");
        isUpdated = false;
    }

    @Override
    public ResultMessage showStatement(Time startTime, Time endTime) {
        if (startTime.compareTo(endTime) < 0) {
            return new ResultMessage("fail");
        }

        try {
            ResultMessage payMsg = showStatementDataServiceImpl.findAllPayBill();
            ResultMessage receiptMsg = showStatementDataServiceImpl.findAllReceiptBill();
            if (payMsg.getKey().equals("fail") || receiptMsg.getKey().equals("fail")) {
                return new ResultMessage("fail");
            }

            List<PayBillPO> payBillPOs = (List<PayBillPO>) payMsg.getValue();
            List<ReceiptBillPO> receiptBillPOs = (List<ReceiptBillPO>) receiptMsg.getValue();

            updateStatementVO(startTime, endTime, payBillPOs, receiptBillPOs);
            return new ResultMessage("success", statementVO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    /**
     * 更新经营情况表
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param payBillPOs 付款单
     * @param receiptBillPOs 收款单
     */
    private void updateStatementVO(Time startTime, Time endTime, List<PayBillPO> payBillPOs, List<ReceiptBillPO> receiptBillPOs) {
        List<PayBillVO> payBillVOs = new ArrayList<>();
        List<ReceiptBillVO> receiptBillVOs = new ArrayList<>();

        for (PayBillPO po : payBillPOs) {
            if (isBetween(po.getTime(), startTime, endTime)) {
                payBillVOs.add(po.poToVo());
            }
        }
        for (ReceiptBillPO po : receiptBillPOs) {
            if (isBetween(po.getTime(), startTime, endTime)) {
                receiptBillVOs.add(po.poToVo());
            }
        }

        isUpdated = true;
        statementVO = new StatementVO(payBillVOs, receiptBillVOs);
    }

    private boolean isBetween(Time t, Time start, Time end) {
        return t.compareTo(start) >= 0 && t.compareTo(end) <= 0;
    }

    @Override
    public ResultMessage statementToExcel() {
        if (!isUpdated) {
            return new ResultMessage("fail");
        }
        isUpdated = false;
        return null;
    }
}
