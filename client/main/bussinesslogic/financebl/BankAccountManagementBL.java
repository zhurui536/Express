package main.bussinesslogic.financebl;

import dataservice.financedataservice.BankAccountManagementDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.BankAccountManagementBLService;
import main.connection.ClientRMIHelper;
import main.vo.financevo.BankAccountVO;
import po.financepo.BankAccountPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 银行账户管理
 * Created by Away
 * 2015/11/15
 */

public class BankAccountManagementBL implements BankAccountManagementBLService {

    BankAccountManagementDataService bankAccountManagementDataServiceImpl;

    public BankAccountManagementBL() {
        bankAccountManagementDataServiceImpl = (BankAccountManagementDataService) ClientRMIHelper.getServiceByName("BankAccountManagementDataServiceImpl");
    }

    @Override
    public ResultMessage createMember(BankAccountVO vo) {
        try {
            BankAccountPO bankAccountPO = new BankAccountPO(vo.name, vo.balance, vo.id);
            return bankAccountManagementDataServiceImpl.insert(bankAccountPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage deleteMember(String id) {
        try {
            return bankAccountManagementDataServiceImpl.delete(id);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage updateMember(BankAccountVO vo) {
        BankAccountPO bankAccountPO = new BankAccountPO(vo.name, vo.id);
        try {
            return bankAccountManagementDataServiceImpl.update(bankAccountPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage inquireMember(BankAccountVO vo) {
        try {
            // 根据 id 查找
            if (vo.id != null) {
                return bankAccountManagementDataServiceImpl.find(vo.id);
            }

            // 根据名字模糊匹配
            ResultMessage message = bankAccountManagementDataServiceImpl.findAll();
            if (message.getKey().equals("fail")) {
                return message;
            }

            ArrayList<BankAccountPO> bankAccountPOs = (ArrayList<BankAccountPO>) message.getValue();
            ArrayList<BankAccountVO> bankAccountVOs = matchName(bankAccountPOs, vo.name);
            if (bankAccountVOs.size() == 0) {
                return new ResultMessage("fail");
            }

            return new ResultMessage("success", bankAccountVOs);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    // TODO 模糊匹配
    private ArrayList<BankAccountVO> matchName(ArrayList<BankAccountPO> bankAccountPOs, String name) {
        ArrayList<BankAccountVO> bankAccountVOs = new ArrayList<>();
        for (BankAccountPO bankAccountPO : bankAccountPOs) {
            if (bankAccountPO.getName().contains(name)) {
                bankAccountVOs.add(bankAccountPO.poToVo());
            }
        }
        return bankAccountVOs;
    }
}
