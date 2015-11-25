package dataservice.financedataservice._driver;

import dataservice.financedataservice.CreatePayListDataService;
import dataservice.financedataservice._stub.CreatePayListDataService_Stub;
import main.bussinesslogic.util.BillType;
import po.BillPO;

import java.rmi.RemoteException;

/**
 * 新建付款单数据层的驱动
 * Created by Away
 * 2015/10/26
 */

public class CreatePayListDataService_Driver {

    public void drive(CreatePayListDataService createPayListDataService) {
        try {
            createPayListDataService.insert(new BillPO("000000001", BillType.DELIVERY, "away"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreatePayListDataService createPayListDataService = new CreatePayListDataService_Stub();
        CreatePayListDataService_Driver createPayListDataService_driver = new CreatePayListDataService_Driver();
        createPayListDataService_driver.drive(createPayListDataService);
    }
}
