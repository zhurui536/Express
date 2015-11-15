package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.ReceiptBillProduceBLService;
import main.vo.BillVO;

/**
 * @author zhuding
 *
 */
public class ReceiptBillProduceBLService_Stub implements ReceiptBillProduceBLService{

        @Override
        public ResultMessage produceReceiptBill() {
                return new ResultMessage("success", new BillVO("00001", BillType.COLLECTION));
        }

}
