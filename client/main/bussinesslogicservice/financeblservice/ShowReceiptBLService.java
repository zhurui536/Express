package main.bussinesslogicservice.financeblservice;

import main.bussinesslogic.util.ResultMessage;

/**
 * Created by Away
 * 2015/10/26
 */

public interface ShowReceiptBLService {

    /**
     * 显示收款单
     * @param time 时间
     * @param id 营业厅号码
     * @return ResultMessage
     */
    ResultMessage showReceipt(long time, long id);
}
