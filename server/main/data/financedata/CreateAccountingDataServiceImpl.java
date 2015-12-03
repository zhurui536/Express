package main.data.financedata;

import dataservice.financedataservice.CreateAccountingDataService;
import main.bussinesslogic.util.ResultMessage;
import po.financepo.AccountPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 期初建账数据层实现
 * Created by Away
 * 2015/12/3
 */

public class CreateAccountingDataServiceImpl extends UnicastRemoteObject implements CreateAccountingDataService {

    private static final long serialVersionUID = -5572836631948624078L;

    private static final String PATH = "server/save/financedata/AccountPO.dat";

    protected CreateAccountingDataServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage initInsert(AccountPO po) throws RemoteException {

    }

}










