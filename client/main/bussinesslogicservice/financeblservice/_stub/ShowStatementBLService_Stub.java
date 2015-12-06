package main.bussinesslogicservice.financeblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.ShowStatementBLService;

/**
 * Created by Away
 * 2015/10/26
 */

public class ShowStatementBLService_Stub implements ShowStatementBLService {

    @Override
    public ResultMessage showStatement(Time startTime, Time endTime) {
        if (startTime.compareTo(endTime) > 0) {
            System.out.println("Show Statement success");
            return new ResultMessage("success", null);
        }
        else {
            System.out.println("Show Statement fail");
            return new ResultMessage("fail", null);
        }
    }

    @Override
    public ResultMessage statementToExcel() {
        return null;
    }
}
