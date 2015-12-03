package main.bussinesslogic.financebl;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.BankAccountManagementBLService;
import main.bussinesslogicservice.financeblservice._stub.FinanceBLService;
import main.connection.ClientInitException;
import main.connection.ClientRMIHelper;
import main.vo.AccountVO;
import main.vo.BankAccountVO;
import po.BankAccountPO;

import java.util.ArrayList;

/**
 * 控制器，用于控制财务层的逻辑
 * Created by Away
 * 2015/11/16
 */

public class FinanceController implements FinanceBLService {

    BankAccountManagementBLService bankAccountManagement;

    public FinanceController() {
        bankAccountManagement = new BankAccountManagementBL();
    }

    // TODO
    public static void main(String[] args) {
        try {
            ClientRMIHelper.init();
        } catch (ClientInitException e) {
            e.printStackTrace();
        }
        FinanceController financeController = new FinanceController();
        BankAccountVO vo = new BankAccountVO("secondTest", null, "123456789");
        BankAccountVO vo2 = new BankAccountVO("hehe", null, "123456789");
        BankAccountVO vo3 = new BankAccountVO("he", null, null);
        financeController.createMember(vo);
        financeController.updateMember(vo2);
        ResultMessage message = financeController.inquireMember(vo2);
        ResultMessage message1 = financeController.inquireMember(vo3);
        ArrayList<BankAccountVO> bankAccountVOs = (ArrayList<BankAccountVO>) message1.getValue();
        System.out.println(message.getKey());
        System.out.println(((BankAccountPO)message.getValue()).getId());
        for (BankAccountVO bankAccountVO : bankAccountVOs) {
            System.out.println(bankAccountVO.name + " " + bankAccountVO.id);
        }
    }

    @Override
    public ResultMessage createMember(BankAccountVO vo) {
        return bankAccountManagement.createMember(vo);
    }

    @Override
    public ResultMessage deleteMember(String id) {
        return bankAccountManagement.deleteMember(id);
    }

    @Override
    public ResultMessage updateMember(BankAccountVO vo) {
        return bankAccountManagement.updateMember(vo);
    }

    @Override
    public ResultMessage inquireMember(BankAccountVO vo) {
        return bankAccountManagement.inquireMember(vo);
    }

    @Override
    public ResultMessage createAccounting(AccountVO accountVO) {
        return new ResultMessage("success", null);
    }

    @Override
    public ResultMessage createPayList() {
        return null;
    }

    @Override
    public ResultMessage showProfitList() {
        return null;
    }

    @Override
    public ResultMessage showReceipt(long time, long id) {
        return null;
    }

    @Override
    public ResultMessage showStatement(long startTime, long endTime) {
        return null;
    }
}
