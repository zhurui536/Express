package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogic.util.BillType;
import main.bussinesslogicservice.logisticsblservice.BillQueryBLService;
import main.po.BillPO;
import main.vo.BillVO;

/**
 * @author zhuding
 *
 */
public class BillQueryBLService_Stub implements BillQueryBLService{
        
        
        @Override
        public BillVO queryBill(String  id) {
                BillPO billPO =  new BillPO("0000000000",BillType.SEND, "zhuding");
                //将PO对象转为VO对象
                return new BillVO(billPO.getID(), billPO.getBillType());
        }

        @Override
        public void endQueryBill() {
                System.out.println("Success!");
        }


}
