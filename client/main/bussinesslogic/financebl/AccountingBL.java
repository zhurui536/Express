package main.bussinesslogic.financebl;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreateAccountingBLService;
import main.vo.AccountVO;

/**
 * 账本
 * Created by Away
 * 2015/11/15
 */

public class AccountingBL implements CreateAccountingBLService {
    @Override
    public ResultMessage createAccounting(AccountVO accountVO) {
        return null;
    }
}
