package bussinesslogic.financebl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JTable;

import bussinesslogicservice.financeblservice.ShowProfitListBLService;
import connection.ClientRMIHelper;
import dataservice.financedataservice.ShowReceiptDataService;
import dataservice.financedataservice.ShowStatementDataService;
import po.financepo.PayBillPO;
import po.logisticpo.ReceiptBillPO;
import util.Excel;
import util.ResultMessage;
import util.Time;
import vo.financevo.ProfitListVO;

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

    @SuppressWarnings("unchecked")
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
    public ResultMessage profitListToExcel(JTable table) {
        Excel excel = new Excel();
        excel.createSheet(table, "成本收益表");
        if (excel.export()) {
        	return new ResultMessage("success");
        } else {
        	return new ResultMessage("no choose");
        }
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
