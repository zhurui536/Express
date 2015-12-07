package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogicservice.logisticsblservice.BillQueryBLService;
import main.vo.logisticvo.SendBillVO;

/**
 * @author zhuding
 *
 */
public class BillQueryBLService_Stub implements BillQueryBLService{
        
        
        @Override
        public SendBillVO queryBill(String  id) {
                return null;
        }

        @Override
        public void endQueryBill() {
                System.out.println("Success!");
        }


}
