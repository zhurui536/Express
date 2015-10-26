package main.bussinesslogicservice.financeblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreatePayListBLService;
import main.bussinesslogicservice.financeblservice._stub.CreatePayListBLService_Stub;

/**
 * Created by Away
 * 2015/10/26
 */

public class CreatePayListBLService_Driver {

    public void drive(CreatePayListBLService createPayListBLService) {

        ResultMessage result = createPayListBLService.createPayList();
        if (result.getKey().equals("success"))
            System.out.println("create paylist pass");
    }

    public static void main(String[] args) {
        CreatePayListBLService createPayListBLService = new CreatePayListBLService_Stub();
        CreatePayListBLService_Driver createPayListBLService_driver = new CreatePayListBLService_Driver();
        createPayListBLService_driver.drive(createPayListBLService);
    }
}
