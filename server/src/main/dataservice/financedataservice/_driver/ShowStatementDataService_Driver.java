package main.dataservice.financedataservice._driver;

import main.dataservice.financedataservice.ShowStatementDataService;
import main.dataservice.financedataservice._stub.ShowStatementDataService_Stub;

import java.rmi.RemoteException;

/**
 * 查看经营情况表数据层的驱动
 * Created by Away
 * 2015/10/26
 */

public class ShowStatementDataService_Driver {

    public void drive(ShowStatementDataService showStatementDataService) {
        try {
            showStatementDataService.find(100, 1000);
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
