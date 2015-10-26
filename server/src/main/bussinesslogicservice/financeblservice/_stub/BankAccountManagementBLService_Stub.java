package main.bussinesslogicservice.financeblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.BankAccountManagementBLService;
import main.vo.BankAccountVO;

import java.util.ArrayList;

/**
 * Created by Away
 * 2015/10/26
 */

public class BankAccountManagementBLService_Stub implements BankAccountManagementBLService {

    public ResultMessage createMember(BankAccountVO vo) {
        System.out.println("Add Success");
        return new ResultMessage("success", null);
    }

    public ResultMessage deleteMember(BankAccountVO vo) {
        System.out.println("Delete Success");
        return new ResultMessage("success", null);
    }

    public ResultMessage updateMember(BankAccountVO vo) {
        System.out.println("Update Success");
        return new ResultMessage("success", null);
    }

    public ResultMessage inquireMember(BankAccountVO vo) {
        System.out.println("Inquire Success");
        ArrayList<BankAccountVO> list = new ArrayList<>();
        return new ResultMessage("success", list);
    }
}
