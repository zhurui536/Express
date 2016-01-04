package bussinesslogicservice.financeblservice;

import util.ResultMessage;

/**
 * Created by Away
 * 2015/11/16
 */

public interface FinanceBLService extends BankAccountManagementBLService, CreateAccountingBLService, CreatePayBillBLService, ShowProfitListBLService, ShowReceiptBLService, ShowStatementBLService{
    ResultMessage showLog();
    
    ResultMessage getAllPayBill();
}
