package dataservice.financedataservice;

import po.financepo.StatementPO;

import java.rmi.RemoteException;

/**
 * 查看经营情况表数据层
 * Created by Away
 * 2015/10/26
 */

public interface ShowStatementDataService {

    /**
     * 找出对应时间段内的经营情况表
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return StatementPO
     */
    StatementPO find(long startTime, long endTime) throws RemoteException;
}
