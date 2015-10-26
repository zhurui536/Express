package main.dataservice.financedataservice._stub;

import main.dataservice.financedataservice.BankAccountManagementDataService;
import main.po.BankAccountPO;
import main.vo.BankAccountVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
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
