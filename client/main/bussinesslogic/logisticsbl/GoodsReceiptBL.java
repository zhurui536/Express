package main.bussinesslogic.logisticsbl;


//import java.util.ArrayList;

import dataservice.logisticsdataservice.GoodsReceiptDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import main.vo.logisticvo.ArrivalBillVO;
import main.vo.logisticvo.LoadingBillVO;

public class GoodsReceiptBL implements GoodsReceiptBLService{

        private GoodsReceiptDataService goodsReceiptDataService;
        
//        private ArrayList<Go>

        @Override
        public ResultMessage produceArrivalBill(ArrivalBillVO arrivalBillVO) {
                String id = arrivalBillVO.transferBillNum;
                
                
                return null;
        }

        @Override
        public ResultMessage produceSendBill(String deliverManId) {
                // TODO Auto-generated method stub
                return null;
        }

        
        @Override
        public void endGoodsreceipt() {
                // TODO Auto-generated method stub
                
        }

}
