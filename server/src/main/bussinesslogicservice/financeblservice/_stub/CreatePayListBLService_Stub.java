package main.bussinesslogicservice.financeblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreatePayListBLService;

/**
 * Created by Away
 * 2015/10/26
 */

public class CreatePayListBLService_Stub implements CreatePayListBLService {

    @Override
    public ResultMessage createPayList() {
        System.out.println("Create PayList Success");
        return new ResultMessage("success", null);
    }
}
