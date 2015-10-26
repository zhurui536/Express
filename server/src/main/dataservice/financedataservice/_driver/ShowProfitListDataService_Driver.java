package main.dataservice.financedataservice._driver;

import main.dataservice.financedataservice.ShowProfitListDataService;
import main.dataservice.financedataservice._stub.ShowProfitListDataService_Stub;

import java.rmi.RemoteException;

/**
 * 查看成本收益表的数据层驱动
 * Created by Away
 * 2015/10/26
 */

public class ShowProfitListDataService_Driver {

    public void drive(ShowProfitListDataService showProfitListDataService) {
        try {
            showProfitListDataService.getProfitList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ShowProfitListDataService showProfitListDataService = new ShowProfitListDataService_Stub();
        ShowProfitListDataService_Driver showProfitListDataService_driver = new ShowProfitListDataService_Driver();
        showProfitListDataService_driver.drive(showProfitListDataService);
    }
}
