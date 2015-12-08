package main.data.financedata;

import dataservice.financedataservice.CreateAccountingDataService;
import main.bussinesslogic.util.ResultMessage;
import main.dao.Database;
import po.financepo.AccountPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * 期初建账数据层实现
 * Created by Away
 * 2015/12/3
 */

public class CreateAccountingDataServiceImpl extends UnicastRemoteObject implements CreateAccountingDataService {

    private static final long serialVersionUID = -5572836631948624078L;

    private static final String INIT_PATH = "server/save/financedata/initAccountPO.dat";

    List<AccountPO> initAccountPOs;

    public CreateAccountingDataServiceImpl() throws RemoteException {
        super();
        init();
    }

    private void init() {
        initAccountPOs = (List<AccountPO>) Database.load(INIT_PATH);
        if (initAccountPOs == null) {
            initAccountPOs = new ArrayList<>();
        }
    }

    @Override
    public ResultMessage initInsert(AccountPO po) throws RemoteException {
        initAccountPOs.add(po);
        Database.save(INIT_PATH, initAccountPOs);
        return new ResultMessage("success");
    }

    @Override
    public ResultMessage findAllInitInfo() throws RemoteException {
        return new ResultMessage("success", initAccountPOs);
    }

}










