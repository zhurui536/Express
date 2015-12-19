package main.data.financedata;

import dataservice.financedataservice.CreatePayBillDataService;
import main.dao.Database;
import po.financepo.PayBillPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Away
 * 2015/12/6
 */

public class CreatePayBillDataServiceImpl extends UnicastRemoteObject implements CreatePayBillDataService {

    private static final long serialVersionUID = 4148855495653449673L;

    private static final String PATH = "src/main/java/save/financedata/payBillPO.dat";

    private List<PayBillPO> payBillPOs;

    public CreatePayBillDataServiceImpl() throws RemoteException {
        super();
        init();
    }

    @Override
    public ResultMessage insert(PayBillPO po) throws RemoteException {
        payBillPOs.add(po);
        Database.save(PATH, payBillPOs);
        return new ResultMessage("success");
    }

    private void init() {
        payBillPOs = (ArrayList<PayBillPO>) Database.load(PATH);
        if (payBillPOs == null)
            payBillPOs = new ArrayList<>();
    }
}
