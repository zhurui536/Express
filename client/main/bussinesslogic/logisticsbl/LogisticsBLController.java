package main.bussinesslogic.logisticsbl;

import main.bussinesslogic.util.GoodsState;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.BillQueryBLService;
import main.bussinesslogicservice.logisticsblservice.DeliveryBLService;
import main.bussinesslogicservice.logisticsblservice.GoodsLoadBLService;
import main.bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import main.bussinesslogicservice.logisticsblservice.LogisticsBLService;
import main.bussinesslogicservice.logisticsblservice.ReceiptBillProduceBLService;
import main.bussinesslogicservice.logisticsblservice.ReceivingBLService;
import main.vo.BillVO;
import main.vo.GoodsVO;
import main.vo.logisticvo.SendBillVO;

public class LogisticsBLController implements LogisticsBLService {

        private BillQueryBLService billQueryBLService;
        
        private DeliveryBLService deliveryBLService;
        
        private GoodsLoadBLService goodsLoadBLService;
        
        private GoodsReceiptBLService goodsReceiptBLService;
        
        private ReceiptBillProduceBLService receiptBillProduceBLService;
        
        private ReceivingBLService receivingBLService;
        
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
        public SendBillVO queryBill(String id) {
                return billQueryBLService.queryBill(id);
        }

        @Override
        public void endQueryBill() {
                billQueryBLService.endQueryBill();
        }

        @Override
        public ResultMessage addRecMessage(String Recipients, String id, long time) {
                return deliveryBLService.addRecMessage(Recipients, id, time);
        }

        @Override
        public void endDelivery() {
                deliveryBLService.endDelivery();
        }

        @Override
        public ResultMessage produceLoadBill(BillVO billVO) {
                return goodsLoadBLService.produceLoadBill(billVO);
        }

        @Override
        public void endGoodsLoad() {
                goodsLoadBLService.endGoodsLoad();
        }

        @Override
        public BillVO produceArrivalBill(BillVO transferBillVO,
                        GoodsState goodsState) {
                return goodsReceiptBLService.produceArrivalBill(transferBillVO, goodsState);
        }

        @Override
        public BillVO produceSendBill(BillVO arrivalBillVO, long deliverManId) {
                return goodsReceiptBLService.produceSendBill(arrivalBillVO, deliverManId);
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
        public void setBillQueryBLService(BillQueryBLService billQueryBLService) {
                this.billQueryBLService = billQueryBLService;
        }

        @Override
        public void setDeliveryBLService(DeliveryBLService deliveryBLService) {
                this.deliveryBLService = deliveryBLService;
        }

        @Override
        public void setGoodsLoadBLService(GoodsLoadBLService goodsLoadBLService) {
                this.goodsLoadBLService = goodsLoadBLService;
        }

        @Override
        public void setGoodsReceiptBLService(GoodsReceiptBLService goodsReceiptBLService) {
                this.goodsReceiptBLService = goodsReceiptBLService;
        }

        @Override
        public void setReceiptBillProduceBLService(
                        ReceiptBillProduceBLService receiptBillProduceBLService) {
                this.receiptBillProduceBLService = receiptBillProduceBLService;
        }

        @Override
        public void setReceivingBLService(ReceivingBLService receivingBLService) {
                this.receivingBLService = receivingBLService;
        }

        
        
}
