package main.bussinesslogicservice.financeblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.ShowReceiptBLService;

/**
 * Created by Away
 * 2015/10/26
 */

public class ShowReceiptBLService_Stub implements ShowReceiptBLService {


    @Override
    public ResultMessage showReceipt(Time time, String id) {
        System.out.println("Show Receipt Success");
        return new ResultMessage("success", null);
    }
}
