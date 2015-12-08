package main.bussinesslogic.financebl;

import dataservice.financedataservice.CreateAccountingDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreateAccountingBLService;
import main.connection.ClientRMIHelper;
import main.vo.AccountVO;
import po.financepo.AccountPO;

/**
 * 账本
 * Created by Away
 * 2015/11/15
 */

public class CreateAccountingBL implements CreateAccountingBLService {

    CreateAccountingDataService createAccountingData;

    public CreateAccountingBL() {
        createAccountingData = (CreateAccountingDataService) ClientRMIHelper.
                getServiceByName("CreateAccountingDataServiceImpl");
    }

    @Override
    public ResultMessage createAccounting(AccountVO accountVO) {
        AccountPO accountPO = new AccountPO(accountVO);
        return null;
    }

    @Override
    public ResultMessage inquireInitInfo() {
        return null;
    }
}
