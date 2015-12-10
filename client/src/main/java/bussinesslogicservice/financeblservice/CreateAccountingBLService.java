package bussinesslogicservice.financeblservice;

import util.ResultMessage;
import vo.financevo.AccountVO;

/**
 * Created by Away
 * 2015/10/26
 */

public interface CreateAccountingBLService {

    /**
     * 期初建账
     * @return ResultMessage
     */
    ResultMessage createAccounting(AccountVO accountVO);

    /**
     * 查看期初信息
     * @return ResultMessage
     */
    ResultMessage inquireInitInfo();
}
