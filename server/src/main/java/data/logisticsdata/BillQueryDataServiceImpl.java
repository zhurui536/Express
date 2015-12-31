package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dataservice.logisticsdataservice.BillQueryDataService;
import po.logisticpo.SendBillPO;
import serialutility.Database;

public class BillQueryDataServiceImpl extends UnicastRemoteObject implements BillQueryDataService{

        private static final long serialVersionUID = 7499240604425522792L;

        private static final String PATH = "save/logisticsdata/sendBillPO.dat";
        
        private List<SendBillPO> sendBillPOs;
        
        public BillQueryDataServiceImpl() throws RemoteException {
                super();
                init();
        }
        
        @SuppressWarnings("unchecked")
        private void init() {
                sendBillPOs = (List<SendBillPO>) Database.load(PATH);
                if(sendBillPOs == null)
                        sendBillPOs = new ArrayList<>();
        }
        
        @Override
        public SendBillPO findBill(String id) throws RemoteException {
                init();
                for (SendBillPO sendBillPO : sendBillPOs) {
                	
                        if(sendBillPO.getId().equals(id))
                                return sendBillPO;
                }
                return null;
        }

}
