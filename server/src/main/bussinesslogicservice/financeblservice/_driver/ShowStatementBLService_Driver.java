package main.bussinesslogicservice.financeblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.ShowStatementBLService;
import main.bussinesslogicservice.financeblservice._stub.ShowStatementBLService_Stub;

/**
 * Created by Away
 * 2015/10/26
 */

public class ShowStatementBLService_Driver {

    public void drive(ShowStatementBLService showStatementBLService) {

        ResultMessage result = showStatementBLService.showStatement(100, 1000);
        if (result.getKey().equals("success"))
            System.out.println("show statement pass");

        result = showStatementBLService.showStatement(1000, 100);
        if (result.getKey().equals("fail"))
            System.out.println("show statement pass");
    }

    public static void main(String[] args) {
        ShowStatementBLService showStatementBLService = new ShowStatementBLService_Stub();
        ShowStatementBLService_Driver showStatementBLService_driver = new ShowStatementBLService_Driver();
        showStatementBLService_driver.drive(showStatementBLService);
    }
}
