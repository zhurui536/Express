package main.bussinesslogic.logisticsbl;

import dataservice.logisticsdataservice.ReceiptBillProduceDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.logisticsblservice.ReceiptBillProduceBLService;

public class ReceiptBillProduceBL implements ReceiptBillProduceBLService{

        private ReceiptBillProduceDataService receiptBillProduceDataService;
        
        @Override
        public ResultMessage produceReceiptBill() {
                Time today = new Time();
                
                return null;
        }

}
