package main.data.financedata;

import dataservice.financedataservice.ShowStatementDataService;
import main.bussinesslogic.util.ResultMessage;
import main.dao.Database;
import po.financepo.PayBillPO;
import po.logisticpo.ReceiptBillPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * 显示经营情况表数据层实现
 * Created by Away
 * 2015/12/6
 */

public class ShowStatementDataServiceImpl extends UnicastRemoteObject implements ShowStatementDataService {

    private static final long serialVersionUID = 2841175035701519270L;

    private static final String RECEIPT_PATH = "server/save/logistics/receiptBillPO.dat";

    private static final String PAY_PATH = "server/save/financedata/payBillPO.dat";

    public ShowStatementDataServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage findAllReceiptBill() throws RemoteException {
        List<ReceiptBillPO> receiptBillPOs = (List<ReceiptBillPO>) Database.load(RECEIPT_PATH);
        if (receiptBillPOs == null) {
            receiptBillPOs = new ArrayList<>();
        }
        return new ResultMessage("success", receiptBillPOs);
    }

    @Override
    public ResultMessage findAllPayBill() throws RemoteException {
        List<PayBillPO> payBillPOs = (List<PayBillPO>) Database.load(PAY_PATH);
        if (payBillPOs == null) {
            payBillPOs = new ArrayList<>();
        }
        return new ResultMessage("success", payBillPOs);
    }
}
