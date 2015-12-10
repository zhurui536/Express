package bussinesslogicservice.financeblservice;

import util.ResultMessage;
import util.Time;

/**
 * 查看收款单逻辑层接口
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
    ResultMessage showReceipt(Time time, String id);
}
