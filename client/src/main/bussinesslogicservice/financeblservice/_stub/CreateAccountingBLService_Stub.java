package main.bussinesslogicservice.financeblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreateAccountingBLService;

/**
 * Created by Away
 * 2015/10/26
 */

public class CreateAccountingBLService_Stub implements CreateAccountingBLService {

    @Override
    public ResultMessage createAccounting() {
        System.out.println("Create Account Success");
        return new ResultMessage("success", null);
    }
}
