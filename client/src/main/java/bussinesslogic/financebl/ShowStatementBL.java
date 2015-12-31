package bussinesslogic.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import bussinesslogicservice.financeblservice.ShowStatementBLService;
import connection.ClientRMIHelper;
import dataservice.financedataservice.ShowReceiptDataService;
import dataservice.financedataservice.ShowStatementDataService;
import po.financepo.PayBillPO;
import po.logisticpo.ReceiptBillPO;
import util.Excel;
import util.ResultMessage;
import util.Time;
import vo.financevo.PayBillVO;
import vo.financevo.StatementVO;
import vo.logisticvo.ReceiptBillVO;

/**
 * 经营情况表逻辑层实现
 * Created by Away
 * 2015/11/15
 */

public class ShowStatementBL implements ShowStatementBLService {

    private ShowStatementDataService showStatementDataServiceImpl;

    private ShowReceiptDataService showReceiptDataServiceImpl;

    private StatementVO statementVO;

    public ShowStatementBL() {
        showStatementDataServiceImpl = (ShowStatementDataService) ClientRMIHelper.
                getServiceByName("ShowStatementDataServiceImpl");
        showReceiptDataServiceImpl = (ShowReceiptDataService) ClientRMIHelper.
                getServiceByName("ShowReceiptDataServiceImpl");
    }

    @SuppressWarnings("unchecked")
    @Override
    public ResultMessage showStatement(Time startTime, Time endTime) {
        try {
            ResultMessage payMsg = showStatementDataServiceImpl.findAllPayBill();
            ResultMessage receiptMsg = showReceiptDataServiceImpl.findAll();
//            if (payMsg.getKey().equals("fail") || receiptMsg.getKey().equals("fail")) {
//                return new ResultMessage("fail");
//            }

            List<PayBillPO> payBillPOs = (List<PayBillPO>) payMsg.getValue();
            List<ReceiptBillPO> receiptBillPOs = (List<ReceiptBillPO>) receiptMsg.getValue();

            updateStatementVO(startTime, endTime, payBillPOs, receiptBillPOs);
            System.out.println(statementVO.payBillVOs.size());
            System.out.println(statementVO.receiptBillVOs.size());
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

        statementVO = new StatementVO(payBillVOs, receiptBillVOs);
    }

    private boolean isBetween(Time t, Time start, Time end) {
//        return t.compareTo(start) >= 0 && t.compareTo(end) <= 0;
    	return true;
    }

    @Override
    public ResultMessage statementToExcel(JTable payTable, JTable receiptTable) {
        Excel excel = new Excel();
        excel.createSheet(payTable, "付款单");
        excel.createSheet(receiptTable, "收款单");
        excel.export();
        return new ResultMessage("success");
    }
}
