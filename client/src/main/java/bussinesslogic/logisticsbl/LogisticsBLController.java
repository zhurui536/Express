package bussinesslogic.logisticsbl;

import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import bussinesslogicservice.logisticsblservice.BillQueryBLService;
import bussinesslogicservice.logisticsblservice.DeliveryBLService;
import bussinesslogicservice.logisticsblservice.GoodsLoadBLService;
import bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import bussinesslogicservice.logisticsblservice.ReceiptBillProduceBLService;
import bussinesslogicservice.logisticsblservice.ReceivingBLService;
import util.City;
import util.LogFactory;
import util.ResultMessage;
import util.Time;
import vo.GoodsVO;
import vo.SystemlogVO;
import vo.logisticvo.ArrivalBillVO;
import vo.logisticvo.LoadingBillVO;
import vo.logisticvo.SendBillVO;
import vo.logisticvo.TransferBillVO;

public class LogisticsBLController implements LogisticsBLService {

        private BillQueryBLService billQueryBLService;

        private DeliveryBLService deliveryBLService;

        private GoodsLoadBLService goodsLoadBLService;

        private GoodsReceiptBLService goodsReceiptBLService;

        private ReceiptBillProduceBLService receiptBillProduceBLService;

        private ReceivingBLService receivingBLService;
        
        private SystemlogMaintenanceBLService service;

        public LogisticsBLController() {
                this.billQueryBLService = new BillQueryBL();
                this.deliveryBLService = new DeliveryBL();
                this.goodsLoadBLService = new GoodsLoadBL();
                this.goodsReceiptBLService = new GoodsReceiptBL();
                this.receiptBillProduceBLService = new ReceiptBillProduceBL();
                this.receivingBLService = new ReceivingBL();
                this.service = LogFactory.getInstance();
        }

        @Override
        public ResultMessage addMessage(SendBillVO billVO) {
                service.addSystemlog(new SystemlogVO("新增收件信息"));
                return receivingBLService.addMessage(billVO);
        }

        @Override
        public long getTime(City departurePlace, City destination) {
                return receivingBLService.getTime(null, null);
        }

        @Override
        public double getCharge(GoodsVO goods) {
                return receivingBLService.getCharge(goods);
        }

        @Override
        public void endReceipt() {
                service.addSystemlog(new SystemlogVO("结束收件信息录入"));
                receivingBLService.endReceipt();
        }

        @Override
        public ResultMessage queryBill(String id) {
                service.addSystemlog(new SystemlogVO("查询订单信息"));
                return billQueryBLService.queryBill(id);
        }

        @Override
        public void endDelivery() {
                service.addSystemlog(new SystemlogVO("结束派件信息录入"));
                deliveryBLService.endDelivery();
        }

        @Override
        public ResultMessage produceArrivalBill(ArrivalBillVO arrivalBillVO) {
                service.addSystemlog(new SystemlogVO("生成到达单"));
                return goodsReceiptBLService.produceArrivalBill(arrivalBillVO);
        }

        @Override
        public ResultMessage produceDeliveryBill(String deliverManId) {
                service.addSystemlog(new SystemlogVO("生成派件单"));
                return goodsReceiptBLService.produceDeliveryBill(deliverManId);
        }

        @Override
        public void endGoodsreceipt() {
                goodsReceiptBLService.endGoodsreceipt();
        }

        @Override
        public ResultMessage produceReceiptBill() {
                service.addSystemlog(new SystemlogVO("生成收款单"));
                return receiptBillProduceBLService.produceReceiptBill();
        }

        @Override
        public ResultMessage produceLoadBill(LoadingBillVO billVO) {
                service.addSystemlog(new SystemlogVO("生成装车单"));
                return goodsLoadBLService.produceLoadBill(billVO);
        }

        @Override
        public ResultMessage addRecMessage(String Recipients, String id,
                                           Time time) {
                service.addSystemlog(new SystemlogVO("录入派件信息"));
                return deliveryBLService.addRecMessage(Recipients, id, time);
        }

        @Override
        public ResultMessage produceTransferBill(TransferBillVO transferBillVO) {
                service.addSystemlog(new SystemlogVO("生成中转单"));
                return goodsLoadBLService.produceTransferBill(transferBillVO);
        }

}
