package main.dataservice.financedataservice;

import main.po.BankAccountPO;
import main.vo.BankAccountVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 银行账户管理数据层
 * Created by Away
 * 2015/10/26
 */

public interface BankAccountManagementDataService {

    ArrayList<BankAccountPO> find(BankAccountVO vo) throws RemoteException;

    void insert(BankAccountPO po) throws RemoteException;

    void delete(BankAccountPO po) throws RemoteException;

    void update(BankAccountPO po) throws RemoteException;

    void init() throws RemoteException;

    void finish() throws RemoteException;
}