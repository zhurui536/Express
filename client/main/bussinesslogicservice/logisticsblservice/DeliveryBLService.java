package main.bussinesslogicservice.logisticsblservice;

import main.bussinesslogic.util.ResultMessage;

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
        public ResultMessage addRecMessage(String Recipients,String id, long time) ;
        
        public void endDelivery();
}
