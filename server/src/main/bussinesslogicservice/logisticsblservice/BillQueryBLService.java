package main.bussinesslogicservice.logisticsblservice;

import main.vo.BillVO;

/**
 * @author zhuding
 *
 */
public interface BillQueryBLService {
        /**
         * 快递员查看订单信息时调用
         * @param id 快递单编号
         */
        public BillVO queryBill(long id);
        
        public void endQueryBill();
}
