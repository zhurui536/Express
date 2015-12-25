package bussinesslogic.financebl;

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

import java.io.IOException;
import java.io.OutputStream;
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

    private ShowReceiptDataService showReceiptDataServiceImpl;

    private StatementVO statementVO;

    // 导出前是否已更新过经营情况表
    private boolean isUpdated;

    public ShowStatementBL() {
        ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
        showStatementDataServiceImpl = (ShowStatementDataService) clientRMIHelper.
                getServiceByName("ShowStatementDataServiceImpl");
        showReceiptDataServiceImpl = (ShowReceiptDataService) clientRMIHelper.
                getServiceByName("ShowReceiptDataServiceImpl");
        isUpdated = false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ResultMessage showStatement(Time startTime, Time endTime) {
        if (isAfter(startTime, endTime)) {
            return new ResultMessage("fail");
        }

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

    private boolean isAfter(Time startTime, Time endTime) {
        return startTime.compareTo(endTime) > 0;
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
//        return t.compareTo(start) >= 0 && t.compareTo(end) <= 0;
    	return true;
    }

    @Override
    public ResultMessage statementToExcel(OutputStream out) {
        if (!isUpdated) {
            return new ResultMessage("fail");
        }
        String[] payHeaders = { "付款时间", "付款单编号", "付款人ID", "付款账号", "条目", "备注", "付款金额" };
        String[] receiveHeaders = { "收款时间", "收款单编号", "营业厅编号", "快递员编号", "订单条形码号", "收款金额" };
        Excel excel = new Excel();
        excel.createSheet(statementVO.payBillVOs, "付款单", payHeaders);
        excel.createSheet(statementVO.receiptBillVOs, "收款单", receiveHeaders);
        excel.export(out);
        isUpdated = false;
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResultMessage("success");
    }
}
