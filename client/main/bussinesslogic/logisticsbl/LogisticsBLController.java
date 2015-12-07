package main.bussinesslogic.logisticsbl;

import main.bussinesslogic.util.*;
import main.bussinesslogicservice.logisticsblservice.*;
import main.vo.GoodsVO;
import main.vo.logisticvo.*;

public class LogisticsBLController implements LogisticsBLService {

        private BillQueryBLService billQueryBLService;
        
        private DeliveryBLService deliveryBLService;
        
        private GoodsLoadBLService goodsLoadBLService;
        
        private GoodsReceiptBLService goodsReceiptBLService;
        
        private ReceiptBillProduceBLService receiptBillProduceBLService;
        
        private ReceivingBLService receivingBLService;
        
        public LogisticsBLController() {
                this.billQueryBLService = new BillQueryBL();
                this.deliveryBLService = new DeliveryBL();
                this.goodsLoadBLService = new GoodsLoadBL();
                this.goodsReceiptBLService = new GoodsReceiptBL();
                this.receiptBillProduceBLService = new ReceiptBillProduceBL();
                this.receivingBLService = new ReceivingBL();
        }

        @Override
        public ResultMessage addMessage(SendBillVO billVO) {
                return receivingBLService.addMessage(billVO);
        }

        @Override
        public long getTime(String departurePlace, String destination) {
                return receivingBLService.getTime(null, null);
        }

        @Override
        public double getCharge(GoodsVO goods) {
                return receivingBLService.getCharge(goods);
        }

        @Override
        public void endReceipt() {
                receivingBLService.endReceipt();
        }

        @Override
        public ResultMessage queryBill(String id) {
                return billQueryBLService.queryBill(id);
        }

        @Override
        public void endDelivery() {
                deliveryBLService.endDelivery();
        }

        @Override
        public ResultMessage produceArrivalBill(ArrivalBillVO arrivalBillVO) {
                return goodsReceiptBLService.produceArrivalBill(arrivalBillVO);
        }

        @Override
        public ResultMessage produceDeliveryBill(String deliverManId) {
                return goodsReceiptBLService.produceDeliveryBill(deliverManId);
        }

        @Override
        public void endGoodsreceipt() {
                goodsReceiptBLService.endGoodsreceipt();
        }

        @Override
        public ResultMessage produceReceiptBill() {
                return receiptBillProduceBLService.produceReceiptBill();
        }

        @Override
        public ResultMessage produceLoadBill(LoadingBillVO billVO) {
                return goodsLoadBLService.produceLoadBill(billVO);
        }



        @Override
        public ResultMessage addRecMessage(String Recipients, String id,
                        Time time) {
                return deliveryBLService.addRecMessage(Recipients, id, time);
        }

        @Override
        public ResultMessage produceTransferBill(TransferBillVO transferBillVO) {
                return goodsLoadBLService.produceTransferBill(transferBillVO);
        }

        

        
        
}
