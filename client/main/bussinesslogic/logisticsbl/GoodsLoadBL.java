package main.bussinesslogic.logisticsbl;

import dataservice.logisticsdataservice.GoodsLoadDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.GoodsLoadBLService;
import main.vo.BillVO;

public class GoodsLoadBL implements GoodsLoadBLService{

        private GoodsLoadDataService goodsLoadDataService;
        
        @Override
        public ResultMessage produceLoadBill(BillVO billVO) {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public void endGoodsLoad() {
                // TODO Auto-generated method stub
        }

}
