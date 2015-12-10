package bussinesslogicservice.logisticsblservice;


import util.ResultMessage;
import vo.GoodsVO;
import vo.logisticvo.SendBillVO;

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
         * @param departurePlace TODO
         * @param destination TODO
         */
        public long getTime(String departurePlace, String destination);
        
        /**
         * 获取快递所需费用
         */
        public double getCharge(GoodsVO goods) ;
        
        /**
         * 结束一次快件信息录入时调用
         */
        public void endReceipt() ;
}
