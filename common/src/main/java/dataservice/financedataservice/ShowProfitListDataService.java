package dataservice.financedataservice;

import java.rmi.RemoteException;

import po.financepo.ProfitListPO;

/**
 * 查看成本收益表数据层
 * Created by Away
 * 2015/10/26
 */

public interface ShowProfitListDataService {

    /**
     * 得到成本收益表
     * @return 成本收益表
     * @throws RemoteException
     */
    ProfitListPO getProfitList() throws RemoteException;
}
