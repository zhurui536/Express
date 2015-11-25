package dataservice.financedataservice._driver;

import dataservice.financedataservice.ShowReceiptDataService;
import dataservice.financedataservice._stub.ShowReceiptDataService_Stub;

import java.rmi.RemoteException;

/**
 * 查看收款单数据层的驱动
 * Created by Away
 * 2015/10/26
 */

public class ShowReceiptDataService_Driver {

    public void drive(ShowReceiptDataService showReceiptDataService) {
        try {
            showReceiptDataService.find(10000, 13213);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ShowReceiptDataService showReceiptDataService = new ShowReceiptDataService_Stub();
        ShowReceiptDataService_Driver showReceiptDataService_driver = new ShowReceiptDataService_Driver();
        showReceiptDataService_driver.drive(showReceiptDataService);
    }
}
