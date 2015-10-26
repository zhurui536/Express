package main.bussinesslogicservice.financeblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.BankAccountVO;

/**
 * Created by Away
 * 2015/10/26
 */

public interface BankAccountManagementBLService {

    /**
     * 增加账户
     * @param vo
     * @return
     */
    ResultMessage createMember(BankAccountVO vo);

    /**
     * 删除账户
     * @param vo
     * @return
     */
    ResultMessage deleteMember(BankAccountVO vo);

    /**
     * 更新账户
     * @param vo
     * @return
     */
    ResultMessage updateMember(BankAccountVO vo);

    /**
     * 查询账户信息
     * @param vo
     * @return
     */
    ResultMessage inquireMember(BankAccountVO vo);
}
