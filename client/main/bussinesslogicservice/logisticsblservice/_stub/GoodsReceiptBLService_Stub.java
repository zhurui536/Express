package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.GoodsState;
import main.bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import main.vo.BillVO;

/**
 * @author zhuding
 *
 */
public class GoodsReceiptBLService_Stub implements GoodsReceiptBLService{

        @Override
        public BillVO produceArrivalBill(BillVO transferBillVO,
                        GoodsState goodsState) {
                //TODO
                //调数据层操作
                return new BillVO(transferBillVO.getID(), BillType.ARRIVAL);
        }

        @Override
        public BillVO produceSendBill(BillVO arrivalBillVO, long deliverManId) {
                //TODO
                //调数据层操作
                return new BillVO(arrivalBillVO.getID(), BillType.DELIVERY);
        }

        @Override
        public void endGoodsreceipt() {
                System.out.println("SUCCESS!");
        }

}
