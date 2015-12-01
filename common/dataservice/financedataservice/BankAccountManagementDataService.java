package dataservice.financedataservice;

import po.BankAccountPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 银行账户管理数据层
 * Created by Away
 * 2015/10/26
 */

public interface BankAccountManagementDataService extends Remote {

    BankAccountPO find(BankAccountPO po) throws RemoteException;

    void insert(BankAccountPO po) throws RemoteException;

    void delete(BankAccountPO po) throws RemoteException;

    void update(BankAccountPO po) throws RemoteException;

    void init() throws RemoteException;

    void finish() throws RemoteException;
}
