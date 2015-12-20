package bussinesslogic.logisticsbl;

import bussinesslogicservice.logisticsblservice.ReceiptBillProduceBLService;
import connection.ClientRMIHelper;
import dataservice.logisticsdataservice.ReceiptBillProduceDataService;
import po.logisticpo.ReceiptBillPO;
import po.logisticpo.ReceiptLineItemPO;
import po.logisticpo.SendBillPO;
import util.PublicMessage;
import util.ResultMessage;
import util.Time;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ReceiptBillProduceBL implements ReceiptBillProduceBLService {

        private ReceiptBillProduceDataService receiptBillProduceDataService;

        public ReceiptBillProduceBL() {
            ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
                receiptBillProduceDataService = (ReceiptBillProduceDataService) clientRMIHelper.getServiceByName("ReceiptBillProduceDataServiceImpl");
        }
        
        @Override
        public ResultMessage produceReceiptBill() {
                Time today = new Time();
                ResultMessage result = null;
                try {
                        result = receiptBillProduceDataService.findGoods(today);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
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
                        sum.add(new BigDecimal(sendBillPO.getGoodsPO()
                                        .getPrice()));
                }
                try {
                        receiptBillProduceDataService.insert(new ReceiptBillPO(
                                        today, sum,
                                        PublicMessage.institutionID,
                                        receiptLineItemPOs, PublicMessage.institutionID + today.toID(),
                                        PublicMessage.staffID));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                return new ResultMessage("SUCCESS");
        }

}
