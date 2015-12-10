package bussinesslogicservice.logisticsblservice;


import util.ResultMessage;

/**
 * @author zhuding
 */
public interface BillQueryBLService {
        /**
         * 快递员查看订单信息时调用
         * @param id 快递单编号
         */
        public ResultMessage queryBill(String id);
        
}
