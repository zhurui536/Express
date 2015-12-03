package dataservice.financedataservice._stub;

import dataservice.financedataservice.BankAccountManagementDataService;
import main.bussinesslogic.util.ResultMessage;
import po.BankAccountPO;

import java.rmi.RemoteException;

/**
 * 银行账户管理数据层桩
 * Created by Away
 * 2015/10/26
 */

public class BankAccountManagementDataService_Stub implements BankAccountManagementDataService {

    @Override
    public ResultMessage find(String id) throws RemoteException {
        System.out.println("find success");
        return null;
    }

    @Override
    public ResultMessage findAll() throws RemoteException {
        System.out.println("find success");
        return null;
    }

    @Override
    public ResultMessage insert(BankAccountPO po) throws RemoteException {
        System.out.println("insert success");
        return null;
    }

    @Override
    public ResultMessage delete(String id) throws RemoteException {
        System.out.println("delete success");
        return null;
    }

    @Override
    public ResultMessage update(BankAccountPO po) throws RemoteException {
        System.out.println("update success");
        return null;
    }
}
