package data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.Database;
import dataservice.financedataservice.ShowStatementDataService;
import po.financepo.PayBillPO;
import util.ResultMessage;

/**
 * 显示经营情况表数据层实现
 * Created by Away
 * 2015/12/6
 */

public class ShowStatementDataServiceImpl extends UnicastRemoteObject implements ShowStatementDataService {

    private static final long serialVersionUID = 2841175035701519270L;

    private static final String PATH = "src/main/java/save/financedata/payBillPO.dat";

    public ShowStatementDataServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage findAllPayBill() throws RemoteException {
        @SuppressWarnings("unchecked")
		List<PayBillPO> payBillPOs = (List<PayBillPO>) Database.load(PATH);
        if (payBillPOs == null) {
            payBillPOs = new ArrayList<>();
        }
        return new ResultMessage("success", payBillPOs);
    }
}
