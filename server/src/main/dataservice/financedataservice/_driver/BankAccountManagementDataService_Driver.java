package main.dataservice.financedataservice._driver;

import main.dataservice.financedataservice.BankAccountManagementDataService;
import main.dataservice.financedataservice._stub.BankAccountManagementDataService_Stub;
import main.po.BankAccountPO;
import main.vo.BankAccountVO;

import java.rmi.RemoteException;

/**
 * 银行账户管理数据层的驱动
 * Created by Away
 * 2015/10/26
 */

public class BankAccountManagementDataService_Driver {

    public void drive(BankAccountManagementDataService bankAccountManagementDataService) {
        try {
            bankAccountManagementDataService.init();
            bankAccountManagementDataService.insert(new BankAccountPO("sleep", 12345, "1023879989"));
            bankAccountManagementDataService.find(new BankAccountVO("killer", 231423, "1232131654"));
            bankAccountManagementDataService.delete(new BankAccountPO("null", 424324, "3320215578"));
            bankAccountManagementDataService.update(new BankAccountPO("none", 424324, "3320215578"));
            bankAccountManagementDataService.finish();
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
