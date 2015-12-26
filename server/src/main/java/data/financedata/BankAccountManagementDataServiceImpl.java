package data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.Database;
import dataservice.financedataservice.BankAccountManagementDataService;
import po.financepo.BankAccountPO;
import util.ResultMessage;

/**
 * Created by Away
 * 2015/11/26
 */

public class BankAccountManagementDataServiceImpl extends UnicastRemoteObject implements BankAccountManagementDataService {

    private static final long serialVersionUID = -7775445166515308020L;

    private static final String PATH = "src/main/java/save/financedata/bankAccountPO.dat";

    private List<BankAccountPO> bankAccountPOs;

    public BankAccountManagementDataServiceImpl() throws RemoteException {
        super();
        init();
    }

    @Override
    // TODO 改文档
    public ResultMessage find(String id) throws RemoteException {
        for (BankAccountPO bankAccountPO : bankAccountPOs) {
            if (bankAccountPO.getId().equals(id))
                return new ResultMessage("success", bankAccountPO);
        }
        return new ResultMessage("fail");
    }

    @Override
    public ResultMessage findAll() throws RemoteException {
        return new ResultMessage("success", bankAccountPOs);
    }

    @Override
    public ResultMessage insert(BankAccountPO po) throws RemoteException {
        ResultMessage message = find(po.getId());
        // 插入的 id 已存在，插入失败
        if (message.getKey().equals("success"))
            return new ResultMessage("fail");
        bankAccountPOs.add(po);
        Database.save(PATH, bankAccountPOs);
        return new ResultMessage("success");
    }

    // TODO 改文档
    @Override
    public ResultMessage delete(String id) throws RemoteException {
        ResultMessage message = find(id);

        if (message.getKey().equals("success")) {
            BankAccountPO bankAccountPO = (BankAccountPO) message.getValue();
            bankAccountPOs.remove(bankAccountPO);
            Database.save(PATH, bankAccountPOs);
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
            Database.save(PATH, bankAccountPOs);
            return new ResultMessage("success");
        } else {
            return new ResultMessage("fail");
        }
    }

    @SuppressWarnings("unchecked")
	private void init() {
        bankAccountPOs = (ArrayList<BankAccountPO>) Database.load(PATH);
        if (bankAccountPOs == null)
            bankAccountPOs = new ArrayList<>();
    }
}