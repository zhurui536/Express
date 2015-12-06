package main.bussinesslogicservice.financeblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.ShowProfitListBLService;

/**
 * Created by Away
 * 2015/10/26
 */

public class ShowProfitListBLService_Stub implements ShowProfitListBLService {

    @Override
    public ResultMessage showProfitList() {
        System.out.println("Show ProfitList Success");
        return new ResultMessage("success", null);
    }

    @Override
    public ResultMessage profitListToExcel() {
        return null;
    }
}
