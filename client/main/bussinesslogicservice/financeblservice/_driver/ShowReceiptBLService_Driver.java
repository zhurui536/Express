package main.bussinesslogicservice.financeblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.ShowReceiptBLService;
import main.bussinesslogicservice.financeblservice._stub.ShowReceiptBLService_Stub;

/**
 * Created by Away
 * 2015/10/26
 */

public class ShowReceiptBLService_Driver {

    public void drive(ShowReceiptBLService showReceiptBLService) {

        ResultMessage result = showReceiptBLService.showReceipt(null, null);
        if (result.getKey().equals("success"))
            System.out.println("show receipt pass");
    }

    public static void main(String[] args) {
        ShowReceiptBLService showReceiptBLService = new ShowReceiptBLService_Stub();
        ShowReceiptBLService_Driver showReceiptBLService_driver = new ShowReceiptBLService_Driver();
        showReceiptBLService_driver.drive(showReceiptBLService);
    }
}
