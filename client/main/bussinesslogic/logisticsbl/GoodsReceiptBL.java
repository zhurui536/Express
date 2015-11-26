package main.bussinesslogic.logisticsbl;


import dataservice.logisticsdataservice.GoodsReceiptDataService;
import main.bussinesslogic.util.GoodsState;
import main.bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import main.vo.BillVO;

public class GoodsReceiptBL implements GoodsReceiptBLService{

        private GoodsReceiptDataService goodsReceiptDataService;

        @Override
        public BillVO produceArrivalBill(BillVO transferBillVO,
                        GoodsState goodsState) {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public BillVO produceSendBill(BillVO arrivalBillVO, long deliverManId) {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public void endGoodsreceipt() {
                // TODO Auto-generated method stub
                
        }

}
