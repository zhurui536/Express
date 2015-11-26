package main.bussinesslogic.financebl;

import dataservice.financedataservice.BankAccountManagementDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.BankAccountManagementBLService;
import main.connection.ClientRMIHelper;
import main.vo.BankAccountVO;
import po.BankAccountPO;

import java.rmi.RemoteException;

/**
 * 银行账户管理
 * Created by Away
 * 2015/11/15
 */

public class BankAccountManagementBL implements BankAccountManagementBLService {
    BankAccountManagementDataService bankAccountManagementData;

    public BankAccountManagementBL() {
        this.bankAccountManagementData = (BankAccountManagementDataService) ClientRMIHelper.getServiceByName("BankAccountManagementData");
    }

    @Override
    public ResultMessage createMember(BankAccountVO vo) {
        BankAccountPO bankAccountPO = new BankAccountPO(vo.getName(), vo.getId());
        try {
            bankAccountManagementData.insert(bankAccountPO);
            return new ResultMessage("create success", null);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("create fail", null);
        }
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
//        try {
//            BankAccountManagementDataService bankAccountManagementData = (BankAccountManagementDataService) ClientRMIHelper.getServiceByName("BankAccountManagementData");
//            ArrayList<BankAccountPO> list =  bankAccountManagementData.find(null);
//            System.out.println(list.get(0).getName());
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
