package main.bussinesslogicservice.logisticsblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.logisticvo.ArrivalBillVO;

/**
 * @author zhuding
 *
 */
public interface GoodsReceiptBLService {
        /**
         * 营业厅业务员或中转中心业务员要求生成相应的到达单时调用
         * @param arrivalBillVO 中转单
         */
        public ResultMessage produceArrivalBill(ArrivalBillVO arrivalBillVO) ;
        

        /**
         * 营业厅业务员要求生成派件单时调用
         * @param deliverManId 快递员id
         */
        public ResultMessage produceDeliveryBill( String deliverManId);
        
        /**
         * 结束一次派件单生成时调用
         */
        public void endGoodsreceipt();
}
