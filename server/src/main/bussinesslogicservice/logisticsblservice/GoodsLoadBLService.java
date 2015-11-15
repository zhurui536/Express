package main.bussinesslogicservice.logisticsblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.BillVO;

public interface GoodsLoadBLService {
        //中转中心业务员要求生成装车单时调用
        public ResultMessage produceLoadBill(BillVO billVO) ;
        //TODO
        //放入文档
        public void endGoodsLoad() ;
}
