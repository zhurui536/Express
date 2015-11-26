package main.bussinesslogicservice.logisticsblservice;

public interface LogisticsBLService extends ReceivingBLService,
                BillQueryBLService, DeliveryBLService, GoodsLoadBLService,
                GoodsReceiptBLService, ReceiptBillProduceBLService {


        public void setBillQueryBLService(BillQueryBLService billQueryBLService) ;

        public void setDeliveryBLService(DeliveryBLService deliveryBLService);

        public void setGoodsLoadBLService(GoodsLoadBLService goodsLoadBLService);

        public void setGoodsReceiptBLService(GoodsReceiptBLService goodsReceiptBLService);

        public void setReceiptBillProduceBLService(
                        ReceiptBillProduceBLService receiptBillProduceBLService);

        public void setReceivingBLService(ReceivingBLService receivingBLService);
        
}
