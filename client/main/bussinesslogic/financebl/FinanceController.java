package main.bussinesslogic.financebl;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.BankAccountManagementBLService;
import main.bussinesslogicservice.financeblservice.CreatePayBillBLService;
import main.bussinesslogicservice.financeblservice.ShowProfitListBLService;
import main.bussinesslogicservice.financeblservice.ShowStatementBLService;
import main.bussinesslogicservice.financeblservice._stub.FinanceBLService;
import main.connection.ClientInitException;
import main.connection.ClientRMIHelper;
import main.vo.AccountVO;
import main.vo.BankAccountVO;
import main.vo.PayBillVO;
import main.vo.StatementVO;
import po.financepo.BankAccountPO;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器，用于控制财务层的逻辑
 * Created by Away
 * 2015/11/16
 */

public class FinanceController implements FinanceBLService {

    private BankAccountManagementBLService bankAccountManagement;

    private CreatePayBillBLService createPayBillBL;

    private ShowProfitListBLService showProfitListBL;

    private ShowStatementBLService showStatementBL;

    public FinanceController() {
        bankAccountManagement = new BankAccountManagementBL();
        createPayBillBL = new CreatePayBillBL();
        showProfitListBL = new ShowProfitListBL();
        showStatementBL = new ShowStatementBL();
    }

    // TODO
    public static void main(String[] args) {
        try {
            ClientRMIHelper.init();
        } catch (ClientInitException e) {
            e.printStackTrace();
        }
        FinanceController financeController = new FinanceController();
        BankAccountVO vo = new BankAccountVO("线性代数", null, "123456789");
        BankAccountVO vo2 = new BankAccountVO("微积分和线性代数", null, "123456789");
        BankAccountVO vo3 = new BankAccountVO("分和", null, null);
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

        Time time = new Time("2015-02-18");
//        BigDecimal money = new BigDecimal(1000.50);
//        StaffMessageVO staffMessageVO = new StaffMessageVO("31423", "hello");
//        String id = "41242";
//        PayItem item = PayItem.SALARY;
//        String remark = "test";
//        PayBillVO payBillVO = new PayBillVO(time, money, staffMessageVO, vo, id, item, remark);
//        financeController.createPayBill(payBillVO);

        ResultMessage resultMessage = financeController.showStatement(time, time);
        StatementVO statementVO = (StatementVO) resultMessage.getValue();
        List<PayBillVO> payBillVOs = statementVO.payBillVOs;
        for (PayBillVO t : payBillVOs) {
            System.out.println(t.staffMessageVO.name);
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
    public ResultMessage inquireInitInfo() {
        return null;
    }

    @Override
    public ResultMessage createPayBill(PayBillVO payBillVO) {
        return createPayBillBL.createPayBill(payBillVO);
    }

    @Override
    public ResultMessage showProfitList() {
        return null;
    }

    @Override
    public ResultMessage profitListToExcel() {
        return null;
    }

    @Override
    public ResultMessage showReceipt(Time time, String id) {
        return null;
    }

    @Override
    // TODO
    public ResultMessage showStatement(Time startTime, Time endTime) {
        return showStatementBL.showStatement(startTime, endTime);
    }

    @Override
    public ResultMessage statementToExcel() {
        return null;
    }
}
