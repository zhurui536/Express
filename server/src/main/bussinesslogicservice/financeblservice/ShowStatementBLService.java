package main.bussinesslogicservice.financeblservice;

import main.bussinesslogic.util.ResultMessage;

/**
 * Created by Away
 * 2015/10/26
 */

public interface ShowStatementBLService {

    /**
     * 显示经营情况表
     * @return ResultMessage
     */
    ResultMessage showStatement(long startTime, long endTime);
}
