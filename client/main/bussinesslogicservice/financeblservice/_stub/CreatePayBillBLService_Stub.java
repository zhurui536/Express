package main.bussinesslogicservice.financeblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreatePayBillBLService;
import main.vo.financevo.PayBillVO;

/**
 * Created by Away
 * 2015/10/26
 */

public class CreatePayBillBLService_Stub implements CreatePayBillBLService {

    @Override
    public ResultMessage createPayBill(PayBillVO payBillVO) {
        System.out.println("Create PayBill Success");
        return new ResultMessage("success", null);
    }
}
