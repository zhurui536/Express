package main.data.financedata;

import dataservice.financedataservice.BankAccountManagementDataService;
import main.bussinesslogic.util.ResultMessage;
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
        database = new Database(PATH);
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
    public ResultMessage findAll() throws RemoteException {
        read();
        return new ResultMessage("success", bankAccountPOs);
    }

    @Override
    public ResultMessage insert(BankAccountPO po) throws RemoteException {
        read();
        bankAccountPOs.add(po);
        database.save(bankAccountPOs);
        return new ResultMessage("success");
    }

    // TODO 改文档
    @Override
    public ResultMessage delete(String id) throws RemoteException {
        ResultMessage message = find(id);

        if (message.getKey().equals("success")) {
            BankAccountPO bankAccountPO = (BankAccountPO) message.getValue();
            bankAccountPOs.remove(bankAccountPO);
            database.save(bankAccountPOs);
            return new ResultMessage("success");
        } else {
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage update(BankAccountPO po) throws RemoteException {
        ResultMessage message = find(po.getId());

        if (message.getKey().equals("success")) {
            BankAccountPO bankAccountPO = (BankAccountPO) message.getValue();
            bankAccountPO.setPO(po);
            database.save(bankAccountPOs);
            return new ResultMessage("success");
        } else {
            return new ResultMessage("fail");
        }
    }

    private void read() {
        bankAccountPOs = (ArrayList<BankAccountPO>) database.load();
        if (bankAccountPOs == null)
            bankAccountPOs = new ArrayList<>();
    }
}
