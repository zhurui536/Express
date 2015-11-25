package dataservice.financedataservice._stub;

import dataservice.financedataservice.BankAccountManagementDataService;
import po.BankAccountPO;
import main.vo.BankAccountVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 银行账户管理数据层桩
 * Created by Away
 * 2015/10/26
 */

public class BankAccountManagementDataService_Stub implements BankAccountManagementDataService {

    @Override
    public ArrayList<BankAccountPO> find(BankAccountVO vo) throws RemoteException {
        ArrayList<BankAccountPO> bankAccountPOs = new ArrayList<>();
        System.out.println("find success");
        return bankAccountPOs;
    }

    @Override
    public void insert(BankAccountPO po) throws RemoteException {
        System.out.println("insert success");
    }

    @Override
    public void delete(BankAccountPO po) throws RemoteException {
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
