package main.bussinesslogicservice.financeblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreateAccountingBLService;
import main.bussinesslogicservice.financeblservice._stub.CreateAccountingBLService_Stub;

/**
 * Created by Away
 * 2015/10/26
 */

public class CreateAccountingBLService_Driver {

    public void drive(CreateAccountingBLService createAccountingBLService) {

        ResultMessage result = createAccountingBLService.createAccounting();
        if (result.getKey().equals("success"))
            System.out.println("create account pass");
    }

    public static void main(String[] args) {
        CreateAccountingBLService createAccountingBLService = new CreateAccountingBLService_Stub();
        CreateAccountingBLService_Driver createAccountingBLService_driver = new CreateAccountingBLService_Driver();
        createAccountingBLService_driver.drive(createAccountingBLService);
    }
}
