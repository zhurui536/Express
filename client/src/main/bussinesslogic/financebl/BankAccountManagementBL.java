package main.bussinesslogic.financebl;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.BankAccountManagementBLService;
import main.dataservice.financedataservice.BankAccountManagementDataService;
import main.po.BankAccountPO;
import main.vo.BankAccountVO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 银行账户管理
 * Created by Away
 * 2015/11/15
 */

public class BankAccountManagementBL implements BankAccountManagementBLService {
    @Override
    public ResultMessage createMember(BankAccountVO vo) {
        return null;
    }

    @Override
    public ResultMessage deleteMember(BankAccountVO vo) {
        return null;
    }

    @Override
    public ResultMessage updateMember(BankAccountVO vo) {
        return null;
    }

    @Override
    public ResultMessage inquireMember(BankAccountVO vo) {
        try {
            BankAccountManagementDataService bankAccountManagementData = (BankAccountManagementDataService) Naming.lookup("rmi://127.0.0.1:6600/bankAccountManagementData");
            ArrayList<BankAccountPO> list =  bankAccountManagementData.find(null);
            System.out.println(list.get(0).getName());
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        BankAccountManagementBL bankAccountManagementBL = new BankAccountManagementBL();
        bankAccountManagementBL.inquireMember(null);
    }
}
