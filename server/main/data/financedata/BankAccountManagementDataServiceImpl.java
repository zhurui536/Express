package main.data.financedata;

import dataservice.financedataservice.BankAccountManagementDataService;
import main.bussinesslogic.util.ResultMessage;
import main.dao.Database;
import po.BankAccountPO;
import utility.ResultState;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by Away
 * 2015/11/26
 */

public class BankAccountManagementDataServiceImpl extends UnicastRemoteObject implements BankAccountManagementDataService {

    private static final String PATH = "server/save/financedata/bankAccountPO.dat";

    private Database database;

    private ArrayList<BankAccountPO> bankAccountPOs;

    public BankAccountManagementDataServiceImpl() throws RemoteException {
        super();
        database = new Database();
    }

    @Override
    // TODO 改文档
    public ResultMessage find(String id) throws RemoteException {
        read();
        for (BankAccountPO bankAccountPO : bankAccountPOs) {
            if (bankAccountPO.getId().equals(id))
                return new ResultMessage("success", bankAccountPO);
        }
        return new ResultMessage("fail");
    }

    @Override
    public void insert(BankAccountPO po) throws RemoteException {
        read();
        bankAccountPOs.add(po);
        database.save(PATH, bankAccountPOs);
    }

    // TODO 改文档
    @Override
    public void delete(String id) throws RemoteException {
        BankAccountPO bankAccountPO = find(id);
        if (bankAccountPO != null) {
            bankAccountPOs.remove(bankAccountPO);
            database.save(PATH, bankAccountPOs);
        }
    }

    @Override
    public void update(BankAccountPO po) throws RemoteException {
        BankAccountPO bankAccountPO = find(po.getId());
        bankAccountPO = po;
    }

    @Override
    public void init() throws RemoteException {

    }

    @Override
    public void finish() throws RemoteException {

    }

    private void read() {
        bankAccountPOs = (ArrayList<BankAccountPO>) database.load(PATH);
        if (bankAccountPOs == null)
            bankAccountPOs = new ArrayList<>();
    }
}
