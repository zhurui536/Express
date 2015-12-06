package dataservice.financedataservice._driver;

import dataservice.financedataservice.ShowStatementDataService;
import dataservice.financedataservice._stub.ShowStatementDataService_Stub;

import java.rmi.RemoteException;

/**
 * 查看经营情况表数据层的驱动
 * Created by Away
 * 2015/10/26
 */

public class ShowStatementDataService_Driver {

    public void drive(ShowStatementDataService showStatementDataService) {
        try {
            showStatementDataService.findAllPayBill();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ShowStatementDataService showStatementDataService = new ShowStatementDataService_Stub();
        ShowStatementDataService_Driver showStatementDataService_driver = new ShowStatementDataService_Driver();
        showStatementDataService_driver.drive(showStatementDataService);
    }
}
