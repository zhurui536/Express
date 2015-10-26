package main.dataservice.financedataservice._stub;

import main.dataservice.financedataservice.ShowProfitListDataService;
import main.po.ProfitListPO;

import java.rmi.RemoteException;

/**
 * 查看成本收益表数据层的桩
 * Created by Away
 * 2015/10/26
 */

public class ShowProfitListDataService_Stub implements ShowProfitListDataService {

    @Override
    public ProfitListPO getProfitList() throws RemoteException {
        System.out.println("get profitlist success");
        return new ProfitListPO(100, 100);
    }
}
