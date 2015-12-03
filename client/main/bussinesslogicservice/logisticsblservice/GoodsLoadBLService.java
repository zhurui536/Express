package main.bussinesslogicservice.logisticsblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.BillVO;
import main.vo.logisticvo.LoadingBillVO;

public interface GoodsLoadBLService {
        //业务员要求生成装车单时调用
        public ResultMessage produceLoadBill(LoadingBillVO billVO) ;
        //TODO
        //放入文档
        public ResultMessage produceTransferBill();
        
        public void endGoodsLoad() ;
}
