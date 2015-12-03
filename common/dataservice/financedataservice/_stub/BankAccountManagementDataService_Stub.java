package dataservice.financedataservice._stub;

import dataservice.financedataservice.BankAccountManagementDataService;
import po.BankAccountPO;

import java.rmi.RemoteException;

/**
 * 银行账户管理数据层桩
 * Created by Away
 * 2015/10/26
 */

public class BankAccountManagementDataService_Stub implements BankAccountManagementDataService {

    @Override
    public BankAccountPO find(String id) throws RemoteException {
        System.out.println("find success");
        return new BankAccountPO(null, null);
    }

    @Override
    public void insert(BankAccountPO po) throws RemoteException {
        System.out.println("insert success");
    }

    @Override
    public void delete(String id) throws RemoteException {
        System.out.println("delete success");
    }

    @Override
    public void update(BankAccountPO po) throws RemoteException {
        System.out.println("update success");
    }

    @Override
    public void init() throws RemoteException {
        System.out.println("init success");
    }

    @Override
    public void finish() throws RemoteException {
        System.out.println("finish success");
    }
}
