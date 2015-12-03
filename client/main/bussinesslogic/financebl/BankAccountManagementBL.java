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
        this.bankAccountManagementData = (BankAccountManagementDataService) ClientRMIHelper.getServiceByName("BankAccountManagementDataServiceImpl");
    }

    @Override
    public ResultMessage createMember(BankAccountVO vo) {
        try {
            ResultMessage message = bankAccountManagementData.find(vo.id);
            // 新建的银行账户 id 已存在时，新增失败
            if (message.getKey().equals("success"))
                return new ResultMessage("fail");

            BankAccountPO bankAccountPO = new BankAccountPO(vo.name, vo.id);
            return bankAccountManagementData.insert(bankAccountPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage deleteMember(String id) {
        try {
            return bankAccountManagementData.delete(id);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage updateMember(BankAccountVO vo) {
        BankAccountPO bankAccountPO = new BankAccountPO(vo.name, vo.id);
        try {
            return bankAccountManagementData.update(bankAccountPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage inquireMember(BankAccountVO vo) {
//        try {
//            BankAccountManagementDataService bankAccountManagementData = (BankAccountManagementDataService) ClientRMIHelper.getServiceByName("BankAccountManagementDataServiceImpl");
//            ArrayList<BankAccountPO> list =  bankAccountManagementData.find(null);
//            System.out.println(list.get(0).getName());
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
