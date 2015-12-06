package main.bussinesslogicservice.financeblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreateAccountingBLService;
import main.bussinesslogicservice.financeblservice._stub.CreateAccountingBLService_Stub;
import main.vo.*;
import main.vo.storevo.StoreVO;

import java.math.BigDecimal;

/**
 * Created by Away
 * 2015/10/26
 */

public class CreateAccountingBLService_Driver {

    public void drive(CreateAccountingBLService createAccountingBLService) {
        InstitutionMessageVO institution = new InstitutionMessageVO();
        StaffMessageVO staff = new StaffMessageVO(null, null);
        TruckMessageVO truck = new TruckMessageVO();
        StoreVO store = new StoreVO(null);
        BankAccountVO bankAccount = new BankAccountVO("kkk", BigDecimal.valueOf(123465), "465456555");

        ResultMessage result = createAccountingBLService.createAccounting(new AccountVO(institution, staff, truck, store, bankAccount));
        if (result.getKey().equals("success"))
            System.out.println("create account pass");
    }

    public static void main(String[] args) {
        CreateAccountingBLService createAccountingBLService = new CreateAccountingBLService_Stub();
        CreateAccountingBLService_Driver createAccountingBLService_driver = new CreateAccountingBLService_Driver();
        createAccountingBLService_driver.drive(createAccountingBLService);
    }
}
