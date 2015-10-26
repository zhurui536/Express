package main.bussinesslogicservice.financeblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.ShowStatementBLService;

/**
 * Created by Away
 * 2015/10/26
 */

public class ShowStatementBLService_Stub implements ShowStatementBLService {

    @Override
    public ResultMessage showStatement() {
        System.out.println("Show Statement success");
        return new ResultMessage("success", null);
    }
}
