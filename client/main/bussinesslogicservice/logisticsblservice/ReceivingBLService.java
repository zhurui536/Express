package main.bussinesslogicservice.logisticsblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.GoodsVO;
import main.vo.logisticvo.SendBillVO;


/**
 * @author zhuding
 *
 */
public interface ReceivingBLService {
        /**
         * 快递员输入快件信息时调用
         */
        public ResultMessage addMessage(SendBillVO billVO) ;
        
        /**
         * 获取快递到达时间
         */
        public long getTime();
        
        /**
         * 获取快递所需费用
         */
        public double getCharge(GoodsVO goods) ;
        
        public void endReceipt() ;
}
