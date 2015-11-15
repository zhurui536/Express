package main.dataservice.financedataservice._driver;

import main.dataservice.financedataservice.CreateAccountingDataService;
import main.dataservice.financedataservice._stub.CreateAccountingDataService_Stub;
import main.po.*;
import main.po.storepo.StorePO;

import java.rmi.RemoteException;

/**
 * 期初建账数据层的驱动
 * Created by Away
 * 2015/10/26
 */

public class CreateAccountingDataService_Driver {

    public void drive(CreateAccountingDataService createAccountingDataService) {
        InstitutionMessagePO institution = new InstitutionMessagePO("hell", "003006");
        StaffMessagePO staff = new StaffMessagePO("韩梅梅", "000111");
        TruckMessagePO truck = new TruckMessagePO("13246578979", "苏A2001", 1);
        StorePO store = new StorePO(2, 3, 3, 3);
        BankAccountPO bankAccount = new BankAccountPO("kkk", 123465, "465456555");
        try {
            createAccountingDataService.initInsert(
                    new AccountPO(institution, staff, truck, store, bankAccount));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateAccountingDataService createAccountingDataService = new CreateAccountingDataService_Stub();
        CreateAccountingDataService_Driver createAccountingDataService_driver = new CreateAccountingDataService_Driver();
        createAccountingDataService_driver.drive(createAccountingDataService);
    }
}
