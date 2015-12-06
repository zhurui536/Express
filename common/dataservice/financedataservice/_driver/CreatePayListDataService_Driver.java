package dataservice.financedataservice._driver;

import dataservice.financedataservice.CreatePayBillDataService;
import dataservice.financedataservice._stub.CreatePayBillDataService_Stub;

import java.rmi.RemoteException;

/**
 * 新建付款单数据层的驱动
 * Created by Away
 * 2015/10/26
 */

public class CreatePayListDataService_Driver {

    public void drive(CreatePayBillDataService createPayBillDataService) {
        try {
            createPayBillDataService.insert(null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreatePayBillDataService createPayBillDataService = new CreatePayBillDataService_Stub();
        CreatePayListDataService_Driver createPayListDataService_driver = new CreatePayListDataService_Driver();
        createPayListDataService_driver.drive(createPayBillDataService);
    }
}
