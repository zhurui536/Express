package bussinesslogic.logisticsbl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import bussinesslogicservice.logisticsblservice.ReceiptBillProduceBLService;
import connection.ClientRMIHelper;
import dataservice.logisticsdataservice.ReceiptBillProduceDataService;
import po.logisticpo.ReceiptBillPO;
import po.logisticpo.ReceiptLineItemPO;
import po.logisticpo.SendBillPO;
import util.BillIDMaker;
import util.BillState;
import util.BillType;
import util.PublicMessage;
import util.ResultMessage;
import util.Time;

public class ReceiptBillProduceBL implements ReceiptBillProduceBLService {

        private ReceiptBillProduceDataService receiptBillProduceDataService;

        public ReceiptBillProduceBL() {
                receiptBillProduceDataService = (ReceiptBillProduceDataService) ClientRMIHelper.getServiceByName("ReceiptBillProduceDataServiceImpl");
        }
        
        @Override
        public ResultMessage produceReceiptBill() {
                Time today = new Time();
                ResultMessage result = null;
                try {
                        result = receiptBillProduceDataService.findGoods(today);
                } catch (RemoteException e) {
                        e.printStackTrace();
                }

                @SuppressWarnings("unchecked")
                ArrayList<SendBillPO> sendBillPOs = (ArrayList<SendBillPO>) result
                                .getValue();
                List<ReceiptLineItemPO> receiptLineItemPOs = new ArrayList<>();
                BigDecimal sum = new BigDecimal(0);
                for (SendBillPO sendBillPO : sendBillPOs) {
                        ReceiptLineItemPO receiptLineItemPO = new ReceiptLineItemPO(
                                        sendBillPO.getDeliveryManID(),
                                        sendBillPO.getId(),
                                        new BigDecimal(sendBillPO.getGoodsPO()
                                                        .getPrice()));
                        receiptLineItemPOs.add(receiptLineItemPO);
                        sum = sum.add(new BigDecimal(sendBillPO.getGoodsPO()
                                        .getPrice()));
                }
                try {
                	ReceiptBillPO receiptbill = new ReceiptBillPO(
                            today, sum,
                            PublicMessage.institutionID,
                            receiptLineItemPOs, BillIDMaker.getID(BillType.RECEIPT),
                            PublicMessage.staffID);
                	receiptbill.setState(BillState.SUBMTTED);
                	
                        receiptBillProduceDataService.insert(receiptbill);
                } catch (RemoteException e) {
                        e.printStackTrace();
                }
                return new ResultMessage("SUCCESS");
        }

}
