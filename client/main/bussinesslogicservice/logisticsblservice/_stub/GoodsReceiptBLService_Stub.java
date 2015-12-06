package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import main.vo.BillVO;
import main.vo.logisticvo.ArrivalBillVO;
import main.vo.logisticvo.LoadingBillVO;

/**
 * @author zhuding
 *
 */
public class GoodsReceiptBLService_Stub implements GoodsReceiptBLService{

        @Override
        public ResultMessage produceArrivalBill(ArrivalBillVO arrivalBillVO) {
                //TODO
                //调数据层操作
//                return new BillVO(arrivalBillVO.getID(), BillType.ARRIVAL);
                return null;
        }

        @Override
        public ResultMessage produceSendBill(String deliverManId) {
                //TODO
                //调数据层操作
                return null;
//                return new BillVO(arrivalBillVO.getID(), BillType.DELIVERY);
        }

        @Override
        public void endGoodsreceipt() {
                System.out.println("SUCCESS!");
        }

}
