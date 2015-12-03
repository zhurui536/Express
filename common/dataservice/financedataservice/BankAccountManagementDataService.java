package dataservice.financedataservice;

import main.bussinesslogic.util.ResultMessage;
import po.BankAccountPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 银行账户管理数据层
 * Created by Away
 * 2015/10/26
 */

public interface BankAccountManagementDataService extends Remote {

    ResultMessage find(String id) throws RemoteException;

    ResultMessage insert(BankAccountPO po) throws RemoteException;

    ResultMessage delete(String id) throws RemoteException;

    ResultMessage update(BankAccountPO po) throws RemoteException;

    ResultMessage init() throws RemoteException;

    ResultMessage finish() throws RemoteException;
}
