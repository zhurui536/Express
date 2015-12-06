package main.bussinesslogicservice.logisticsblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.logisticvo.LoadingBillVO;
import main.vo.logisticvo.TransferBillVO;

public interface GoodsLoadBLService {
        //业务员要求生成装车单时调用
        public ResultMessage produceLoadBill(LoadingBillVO billVO) ;
        //TODO
        //放入文档
        public ResultMessage produceTransferBill(TransferBillVO transferBillVO);
        
        public void endGoodsLoad() ;
}
