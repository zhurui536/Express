package main.bussinesslogicservice.logisticsblservice;

import main.bussinesslogic.util.GoodsState;
import main.po.BillPO;

/**
 * @author zhuding
 *
 */
public interface GoodsReceiptBLService {
        /**
         * 营业厅业务员或中转中心业务员要求生成相应的到达单时调用
         * @param transferBillVO 中转单
         * @param goodsState 货物状态
         */
        public BillVO produceArrivalBill(BillVO transferBillVO,GoodsState goodsState) ;
        
        /**
         * 营业厅业务员要求生成派件单时调用
         * @param arrivalBillVO 到达单
         * @param deliverManId 快递员id
         */
        public BillVO produceSendBill( BillVO arrivalBillVO, long deliverManId);
        
        public void endGoodsreceipt();
}
