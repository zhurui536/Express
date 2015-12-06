package main.bussinesslogicservice.financeblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreatePayBillBLService;
import main.bussinesslogicservice.financeblservice._stub.CreatePayBillBLService_Stub;

/**
 * Created by Away
 * 2015/10/26
 */

public class CreatePayListBLService_Driver {

    public void drive(CreatePayBillBLService createPayBillBLService) {

        ResultMessage result = createPayBillBLService.createPayBill(null);
        if (result.getKey().equals("success"))
            System.out.println("create payBill pass");
    }

    public static void main(String[] args) {
        CreatePayBillBLService createPayBillBLService = new CreatePayBillBLService_Stub();
        CreatePayListBLService_Driver createPayListBLService_driver = new CreatePayListBLService_Driver();
        createPayListBLService_driver.drive(createPayBillBLService);
    }
}
