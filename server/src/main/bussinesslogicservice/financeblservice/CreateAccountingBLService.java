package main.bussinesslogicservice.financeblservice;

import main.bussinesslogic.util.ResultMessage;

/**
 * Created by Away
 * 2015/10/26
 */

public interface CreateAccountingBLService {

    /**
     * 期初建账
     * @return ResultMessage
     */
    ResultMessage createAccounting();
}
