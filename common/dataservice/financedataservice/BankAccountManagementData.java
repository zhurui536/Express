package dataservice.financedataservice;

import po.BankAccountPO;
import main.vo.BankAccountVO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by Away
 * 2015/11/25
 */

public class BankAccountManagementData extends UnicastRemoteObject implements BankAccountManagementDataService {

    public BankAccountManagementData() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<BankAccountPO> find(BankAccountVO vo) throws RemoteException {
        BankAccountPO bankAccount = new BankAccountPO("test", 123, "313");
        ArrayList<BankAccountPO> list = new ArrayList<>();
        list.add(bankAccount);
        return list;
    }

    @Override
    public void insert(BankAccountPO po) throws RemoteException {

    }

    @Override
    public void delete(BankAccountPO po) throws RemoteException {

    }

    @Override
    public void update(BankAccountPO po) throws RemoteException {

    }

    @Override
    public void init() throws RemoteException {

    }

    @Override
    public void finish() throws RemoteException {

    }
}
