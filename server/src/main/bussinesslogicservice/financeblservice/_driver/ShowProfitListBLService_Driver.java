package main.bussinesslogicservice.financeblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.ShowProfitListBLService;
import main.bussinesslogicservice.financeblservice._stub.ShowProfitListBLService_Stub;

/**
 * Created by Away
 * 2015/10/26
 */

public class ShowProfitListBLService_Driver {

    public void drive(ShowProfitListBLService showProfitListBLService) {

        ResultMessage result = showProfitListBLService.showProfitList();
        if (result.getKey().equals("success"))
            System.out.println("show profitlist pass");
    }

    public static void main(String[] args) {
        ShowProfitListBLService showProfitListBLService = new ShowProfitListBLService_Stub();
        ShowProfitListBLService_Driver showProfitListBLService_driver = new ShowProfitListBLService_Driver();
        showProfitListBLService_driver.drive(showProfitListBLService);
    }
}
