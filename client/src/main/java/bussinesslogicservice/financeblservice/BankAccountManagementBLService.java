package bussinesslogicservice.financeblservice;

import util.ResultMessage;
import vo.financevo.BankAccountVO;

/**
 * Created by Away
 * 2015/10/26
 */

public interface BankAccountManagementBLService {

    /**
     * 增加账户
     * @param vo
     * @return ResultMessage
     */
    ResultMessage createMember(BankAccountVO vo);

    /**
     * 删除账户
     * @param id 账户 id
     * @return ResultMessage
     */
    ResultMessage deleteMember(String id);

    /**
     * 更新账户
     * @param vo
     * @return ResultMessage
     */
    ResultMessage updateMember(BankAccountVO vo);

    /**
     * 查询账户信息
     * @param vo
     * @return ResultMessage
     */
    ResultMessage inquireMember(BankAccountVO vo);
    
    /**
     * 显示所有账户信息
     * @return
     */
    ResultMessage showAllMember();
}
