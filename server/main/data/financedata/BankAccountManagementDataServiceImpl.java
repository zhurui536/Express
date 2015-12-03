package main.data.financedata;

import dataservice.financedataservice.BankAccountManagementDataService;
import main.dao.Database;
import po.BankAccountPO;

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
    public BankAccountPO find(BankAccountPO po) throws RemoteException {
        read();
        for (BankAccountPO bankAccountPO : bankAccountPOs) {
            if (po.equals(bankAccountPO))
                return bankAccountPO;
        }
        return null;
    }

    @Override
    public void insert(BankAccountPO po) throws RemoteException {
        read();
        bankAccountPOs.add(po);
        database.save(PATH, bankAccountPOs);
    }

    @Override
    public void delete(BankAccountPO po) throws RemoteException {
        BankAccountPO bankAccountPO = find(po);
        if (bankAccountPO != null) {
            bankAccountPOs.remove(bankAccountPO);
            database.save(PATH, bankAccountPOs);
        }
    }

    @Override
    public void update(BankAccountPO po) throws RemoteException {

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
