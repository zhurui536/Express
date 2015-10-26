package main.bussinesslogicservice.logisticsblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.BillVO;
import main.vo.GoodsVO;


/**
 * @author zhuding
 *
 */
public interface ReceivingBLService {
        /**
         * 快递员输入快件信息时调用
         */
        public ResultMessage addMessage(BillVO billVO) ;
        
        /**
         * 获取快递到达时间
         */
        public long getTime(String destination);
        //参数可以去掉
        
        /**
         * 获取快递所需费用
         */
        public double getCharge(GoodsVO goods) ;
        
        public void endReceipt() ;
}
