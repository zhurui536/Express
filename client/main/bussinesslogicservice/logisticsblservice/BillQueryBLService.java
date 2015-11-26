package main.bussinesslogicservice.logisticsblservice;

import main.vo.logisticvo.SendBillVO;


/**
 * @author zhuding
 *
 */
public interface BillQueryBLService {
        /**
         * 快递员查看订单信息时调用
         * @param id 快递单编号
         * @return TODO
         */
        public SendBillVO queryBill(String id);
        
        public void endQueryBill();
}
