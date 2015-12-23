package bussinesslogicservice.financeblservice;


import java.io.OutputStream;

import util.ResultMessage;
import util.Time;

/**
 * 经营情况表接口
 * Created by Away
 * 2015/10/26
 */

public interface ShowStatementBLService {

    /**
     * 显示经营情况表
     * @return ResultMessage 成功返回 SUCCESS 和 statementVO，失败返回 FAIL
     */
    ResultMessage showStatement(Time startTime, Time endTime);

    /**
     * 导出为 excel
     * @return ResultMessage 成功返回 SUCCESS，失败返回 FAIL。
     */
    ResultMessage statementToExcel(OutputStream out);
}
