package main.bussinesslogic.financebl;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice._stub.FinanceBLService;
import main.vo.AccountVO;
import main.vo.BankAccountVO;

/**
 * Created by Away
 * 2015/11/16
 */

public class FinanceController implements FinanceBLService {
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
        return null;
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
