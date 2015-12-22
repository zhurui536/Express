package bussinesslogic.financebl;

import bussinesslogicservice.financeblservice.*;
import util.PayItem;
import util.ResultMessage;
import util.Time;
import vo.financevo.AccountVO;
import vo.financevo.BankAccountVO;
import vo.financevo.PayBillVO;

import java.io.OutputStream;
import java.math.BigDecimal;

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

    private ShowReceiptBLService showReceiptBL;

    private CreateAccountingBLService createAccountingBL;
    
    public FinanceController() {
        bankAccountManagement = new BankAccountManagementBL();
        createPayBillBL = new CreatePayBillBL();
        showProfitListBL = new ShowProfitListBL();
        showStatementBL = new ShowStatementBL();
        showReceiptBL = new ShowReceiptBL();
        createAccountingBL = new CreateAccountingBL();
    }

    // TODO
    public static void main(String[] args) {
//        try {
//            ClientRMIHelper.init();
//        } catch (ClientInitException e) {
//            e.printStackTrace();
//        }
        FinanceController financeController = new FinanceController();
//        BankAccountVO vo = new BankAccountVO("线性代数", null, "123456789");
//        BankAccountVO vo2 = new BankAccountVO("微积分和线性代数", null, "123456789");
//        BankAccountVO vo3 = new BankAccountVO("分和", null, null);
//        financeController.createMember(vo);
//        financeController.updateMember(vo2);
//        ResultMessage message = financeController.inquireMember(vo2);
//        ResultMessage message1 = financeController.inquireMember(vo3);
//        ArrayList<BankAccountVO> bankAccountVOs = (ArrayList<BankAccountVO>) message1.getValue();
//        System.out.println(message.getKey());
//        System.out.println(((BankAccountPO)message.getValue()).getId());
//        for (BankAccountVO bankAccountVO : bankAccountVOs) {
//            System.out.println(bankAccountVO.name + " " + bankAccountVO.id);
//        }
//
        Time time = new Time();
        BigDecimal money = new BigDecimal(1000.50);
        String staffID = "123456";
        String id = "41242";
        PayItem item = PayItem.SALARY;
        String remark = "test";
        PayBillVO payBillVO = new PayBillVO(time, money, staffID, id, "000000", item, remark);
        financeController.createPayBill(payBillVO);
//
//        ResultMessage resultMessage = financeController.showStatement(time, time);
//        StatementVO statementVO = (StatementVO) resultMessage.getValue();
//        List<PayBillVO> payBillVOs = statementVO.payBillVOs;
//        for (PayBillVO t : payBillVOs) {
//            System.out.println(t.staffMessageVO.name);
//        }
//
//        List<ReceiptBillVO> receiptBillVOs = (List<ReceiptBillVO>) financeController.showReceipt(time, "1234").getValue();
//        for (ReceiptBillVO vo1 : receiptBillVOs) {
//            List<ReceiptLineItemVO> receiptLineItemVOs = vo1.receiptLineItemVOs;
//            for (ReceiptLineItemVO vo4 : receiptLineItemVOs) {
//                System.out.println(vo4.barCode);
//            }
//        }
//
//        ProfitListVO profitListVO = (ProfitListVO) financeController.showProfitList().getValue();
//        System.out.println(profitListVO.pay + "\n" + profitListVO.income + "\n" + profitListVO.profit);
//        financeController.profitListToExcel();
//
//        InstitutionMessageVO institution = new InstitutionMessageVO(null,null,null);
//        StaffMessageVO staff = new StaffMessageVO(null, null);
//        TruckMessageVO truck = new TruckMessageVO(null,null,0);
//        StoreVO store = new StoreVO(new ArrayList<StorePlaceVO>(), 0, 0, 0, 0);
//        BankAccountVO bankAccount = new BankAccountVO("kkk", BigDecimal.valueOf(123465), "465456555");
//        financeController.createAccounting(new AccountVO(institution, staff, truck, store, bankAccount, new Time()));
//        List<AccountVO> accountVOs = (List<AccountVO>) financeController.inquireInitInfo().getValue();
//        for (AccountVO accountVO : accountVOs) {
//            System.out.println(accountVO.bankAccountVO.name + "\n" +
//                                accountVO.time);
//        }
        financeController.showStatement(new Time(), new Time());
        financeController.statementToExcel();
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
        return createAccountingBL.createAccounting(accountVO);
    }

    @Override
    public ResultMessage inquireInitInfo() {
        return createAccountingBL.inquireInitInfo();
    }

    @Override
    public ResultMessage createPayBill(PayBillVO payBillVO) {
        return createPayBillBL.createPayBill(payBillVO);
    }

    @Override
    public ResultMessage showProfitList() {
        return showProfitListBL.showProfitList();
    }

    @Override
    public ResultMessage profitListToExcel(OutputStream out) {
        return showProfitListBL.profitListToExcel(out);
    }

    @Override
    public ResultMessage showReceipt(Time time, String id) {
        return showReceiptBL.showReceipt(time, id);
    }

    @Override
    // TODO
    public ResultMessage showStatement(Time startTime, Time endTime) {
        return showStatementBL.showStatement(startTime, endTime);
    }

    @Override
    public ResultMessage statementToExcel() {
        return showStatementBL.statementToExcel();
    }
}
