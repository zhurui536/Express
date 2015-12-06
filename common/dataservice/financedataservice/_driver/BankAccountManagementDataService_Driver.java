package dataservice.financedataservice._driver;

import dataservice.financedataservice.BankAccountManagementDataService;
import dataservice.financedataservice._stub.BankAccountManagementDataService_Stub;
import po.financepo.BankAccountPO;

import java.math.BigDecimal;
import java.rmi.RemoteException;

/**
 * 银行账户管理数据层的驱动
 * Created by Away
 * 2015/10/26
 */

public class BankAccountManagementDataService_Driver {

    public void drive(BankAccountManagementDataService bankAccountManagementDataService) {
        try {
            bankAccountManagementDataService.insert(new BankAccountPO("sleep", BigDecimal.valueOf(12345), "1023879989"));
            bankAccountManagementDataService.find("1232131654");
            bankAccountManagementDataService.delete("3320215578");
            bankAccountManagementDataService.update(new BankAccountPO("none", BigDecimal.valueOf(424324), "3320215578"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BankAccountManagementDataService bankAccountManagementDataService = new BankAccountManagementDataService_Stub();
        BankAccountManagementDataService_Driver bankAccountManagementDataService_driver = new BankAccountManagementDataService_Driver();
        bankAccountManagementDataService_driver.drive(bankAccountManagementDataService);
    }
}
