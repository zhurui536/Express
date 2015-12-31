package data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dataservice.financedataservice.CreatePayBillDataService;
import po.financepo.PayBillPO;
import serialutility.Database;
import util.ResultMessage;

/**
 * Created by Away
 * 2015/12/6
 */

public class CreatePayBillDataServiceImpl extends UnicastRemoteObject implements CreatePayBillDataService {

    private static final long serialVersionUID = 4148855495653449673L;

    private static final String PATH = "save/financedata/payBillPO.dat";

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

    @SuppressWarnings("unchecked")
	private void init() {
        payBillPOs = (ArrayList<PayBillPO>) Database.load(PATH);
        if (payBillPOs == null)
            payBillPOs = new ArrayList<>();
    }
}
