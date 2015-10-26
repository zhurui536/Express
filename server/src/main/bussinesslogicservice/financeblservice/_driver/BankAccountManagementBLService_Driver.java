package main.bussinesslogicservice.financeblservice._driver;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.BankAccountManagementBLService;
import main.bussinesslogicservice.financeblservice._stub.BankAccountManagementBLService_Stub;
import main.vo.BankAccountVO;

/**
 * Created by Away
 * 2015/10/26
 */

public class BankAccountManagementBLService_Driver {

    public void drive(BankAccountManagementBLService bankAccountManagementBLService) {
        BankAccountVO vo = new BankAccountVO("Away", 2147483647, "6822222222");

        ResultMessage result = bankAccountManagementBLService.createMember(vo);
        if (result.getKey().equals("success"))
            System.out.println("add pass");

        result = bankAccountManagementBLService.inquireMember(vo);
        if (result.getKey().equals("success"))
            System.out.println("inquire pass");

        result = bankAccountManagementBLService.updateMember(vo);
        if (result.getKey().equals("success"))
            System.out.println("update pass");

        result = bankAccountManagementBLService.deleteMember(vo);
        if (result.getKey().equals("success"))
            System.out.println("delete pass");
    }

    public static void main(String[] args) {
        BankAccountManagementBLService bankAccountManagementBLService = new BankAccountManagementBLService_Stub();
        BankAccountManagementBLService_Driver bankAccountManagementBLService_driver = new BankAccountManagementBLService_Driver();
        bankAccountManagementBLService_driver.drive(bankAccountManagementBLService);
    }
}
