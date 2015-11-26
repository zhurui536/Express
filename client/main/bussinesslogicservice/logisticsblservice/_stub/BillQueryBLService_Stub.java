package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogic.util.BillType;
import main.bussinesslogicservice.logisticsblservice.BillQueryBLService;
import po.BillPO;
import main.vo.BillVO;
import main.vo.logisticvo.SendBillVO;

/**
 * @author zhuding
 *
 */
public class BillQueryBLService_Stub implements BillQueryBLService{
        
        
        @Override
        public SendBillVO queryBill(String  id) {
                BillPO billPO =  new BillPO("0000000000",BillType.SEND, "zhuding");
                //将PO对象转为VO对象
                return null;
        }

        @Override
        public void endQueryBill() {
                System.out.println("Success!");
        }


}
