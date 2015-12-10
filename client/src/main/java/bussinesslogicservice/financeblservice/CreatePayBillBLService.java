package bussinesslogicservice.financeblservice;

import util.ResultMessage;
import vo.financevo.PayBillVO;

/**
 * 新建付款单
 * Created by Away
 * 2015/10/26
 */

public interface CreatePayBillBLService {

    /**
     * TODO 改文档
     * 创建付款单
     * @return ResultMessage
     */
    ResultMessage createPayBill(PayBillVO payBillVO);

}
