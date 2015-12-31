package bussinesslogicservice.financeblservice;


import javax.swing.JTable;

import util.ResultMessage;

/**
 * Created by Away
 * 2015/10/26
 */

public interface ShowProfitListBLService {

    /**
     * 查看成本收益表
     * @return ResultMessage
     */
    ResultMessage showProfitList();

    /**
     * 导出为 excel 表
     * @return ResultMessage 成功为 SUCCESS 失败为 FAIL
     */
    ResultMessage profitListToExcel(JTable table);
}
