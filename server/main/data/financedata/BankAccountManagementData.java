package main.data.financedata;

import dataservice.financedataservice.BankAccountManagementDataService;
import main.vo.BankAccountVO;
import po.BankAccountPO;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by Away
 * 2015/11/26
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
        String filepath = "server/save/financedata/bankAccountPO.dat";
        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
            ArrayList<BankAccountPO> bankAccountPOs = (ArrayList<BankAccountPO>) ois.readObject();
//            ArrayList<BankAccountPO> bankAccountPOs = new ArrayList<>();
            System.out.println(bankAccountPOs.get(0).getName() + " " + bankAccountPOs.get(0).getId());
//            oos.writeObject(bankAccountPOs);
//            oos.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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
