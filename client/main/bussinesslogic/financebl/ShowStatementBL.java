package main.bussinesslogic.financebl;

import dataservice.financedataservice.ShowStatementDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.ShowStatementBLService;
import main.connection.ClientRMIHelper;
import po.financepo.PayBillPO;
import po.logisticpo.ReceiptBillPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * 经营情况表逻辑层实现
 * Created by Away
 * 2015/11/15
 */

public class ShowStatementBL implements ShowStatementBLService {

    private ShowStatementDataService showStatementDataServiceImpl;

    public ShowStatementBL() {
        showStatementDataServiceImpl = (ShowStatementDataService) ClientRMIHelper.
                getServiceByName("ShowStatementDataServiceImpl");
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
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultMessage statementToExcel() {
        return null;
    }
}
