package main.bussinesslogic.logisticsbl;

import dataservice.logisticsdataservice.GoodsReceiptDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.GoodsLoadBLService;
import main.vo.BillVO;

public class GoodsReceiptBL implements GoodsLoadBLService{

        private GoodsReceiptDataService goodsReceiptDataService;
        
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
