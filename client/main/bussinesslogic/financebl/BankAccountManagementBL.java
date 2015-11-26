package main.bussinesslogic.financebl;

import dataservice.financedataservice.BankAccountManagementDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.BankAccountManagementBLService;
import main.connection.ClientRMIHelper;
import main.vo.BankAccountVO;
import po.BankAccountPO;

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
            BankAccountManagementDataService bankAccountManagementData = (BankAccountManagementDataService) ClientRMIHelper.getServiceByName("BankAccountManagementData");
            ArrayList<BankAccountPO> list =  bankAccountManagementData.find(null);
            System.out.println(list.get(0).getName());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
