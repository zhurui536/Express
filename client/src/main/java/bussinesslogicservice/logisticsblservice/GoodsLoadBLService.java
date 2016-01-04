package bussinesslogicservice.logisticsblservice;

import util.ResultMessage;
import vo.logisticvo.LoadingBillVO;
import vo.logisticvo.TransferBillVO;

public interface GoodsLoadBLService {
        
        /**
         * 业务员要求生成装车单时调用
         * @param billVO 装车单的VO
         * @return 
         */
        public ResultMessage produceLoadBill(LoadingBillVO billVO) ;
        
        /**
         * 中转中心业务员要求生成中转单时调用，并同时进行出库操作
         * @param transferBillVO 中转单
         */
        public ResultMessage produceTransferBill(TransferBillVO transferBillVO);
        
        /*向中转单或者装车单进行添加货物的时候使用
         * id 货物编号（订单号）
         * 
         */
        public ResultMessage addGoods(String id);
        
        /*输入车辆代号时使用
         * id
         */
        public ResultMessage checkTruck(String id);
}
