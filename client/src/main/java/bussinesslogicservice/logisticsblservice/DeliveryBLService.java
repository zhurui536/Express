package bussinesslogicservice.logisticsblservice;

import util.ResultMessage;
import util.Time;

/**
 * @author zhuding
 *
 */
public interface DeliveryBLService {
        /**
         * 快递员派件后记录收件信息调用
         * @param Recipients 收件人姓名
         * @param id 单据编号
         * @param time 收件时间
         */
        public ResultMessage addRecMessage(String Recipients, String id, Time time) ;
        
        /**
         * 结束记录收件信息时调用
         */
        public void endDelivery();
}
