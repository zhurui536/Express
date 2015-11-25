package test.tester.logisticstester;

import static org.junit.Assert.*;
import main.bussinesslogic.logisticsbl.LogisticsBLController;
import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.LogisticsBLService;
import main.vo.BillVO;

import org.junit.Test;

public class ReceivingTester {
    
    @Test
    public void test() {
        LogisticsBLService logisticsBLService = new LogisticsBLController();
        ResultMessage message = logisticsBLService.addMessage(new BillVO("null", BillType.SEND));
        
        assertEquals("success",message.getKey());
        
    }
}
