package main.data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


import dataservice.logisticsdataservice.ReceiptBillProduceDataService;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.dao.Database;
import po.logisticpo.ReceiptBillPO;
import po.logisticpo.SendBillPO;

public class ReceiptBillProduceDataServiceImpl extends UnicastRemoteObject implements ReceiptBillProduceDataService{

        private static final long serialVersionUID = 1L;
        
        private static final String PATH_RECEIPT_BILL = "server/save/logisticsdata/receiptBillPO.dat";
        
        private static final String PATH_SEND_BILL = "server/save/data/logistics/sendBillPO.dat";
        
        private ArrayList<SendBillPO> sendBillPOs;
        
        private ArrayList<ReceiptBillPO> receiptBillPOs;
        
        public ReceiptBillProduceDataServiceImpl() throws RemoteException {
                super();
                init();
        }

        @SuppressWarnings("unchecked")
        private void init() {
                sendBillPOs = (ArrayList<SendBillPO>) Database.load(PATH_SEND_BILL);
                if(sendBillPOs == null)
                        sendBillPOs = new ArrayList<>();
                receiptBillPOs = (ArrayList<ReceiptBillPO>) Database.load(PATH_RECEIPT_BILL);
                if(receiptBillPOs == null)
                        receiptBillPOs = new ArrayList<>();
        }
        
        @Override
        public ResultMessage findGoods(Time time) throws RemoteException {
                init();
                ArrayList<SendBillPO> result = new ArrayList<>();
                for (SendBillPO sendBillPO : sendBillPOs) {
                        if(sendBillPO.getGoodsPO().getStartTime().equalsWithDay(time))
                                result.add(sendBillPO);
                }
                return new ResultMessage("SUCCESS", result);
        }

        @Override
        public ResultMessage insert(ReceiptBillPO receiptBillPO)
                        throws RemoteException {
                receiptBillPOs.add(receiptBillPO);
                Database.save(PATH_RECEIPT_BILL, receiptBillPOs);
                return new ResultMessage("SUCCESS");
        }

}
