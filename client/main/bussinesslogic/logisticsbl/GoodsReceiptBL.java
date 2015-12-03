package main.bussinesslogic.logisticsbl;


import dataservice.logisticsdataservice.GoodsReceiptDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import main.vo.logisticvo.ArrivalBillVO;

public class GoodsReceiptBL implements GoodsReceiptBLService{

        private GoodsReceiptDataService goodsReceiptDataService;

        @Override
        public ResultMessage produceArrivalBill(ArrivalBillVO arrivalBillVO) {
                // TODO Auto-generated method stub
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
