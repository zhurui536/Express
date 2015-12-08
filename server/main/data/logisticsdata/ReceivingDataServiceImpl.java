package main.data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.dao.Database;
import po.logisticpo.SendBillPO;

import dataservice.logisticsdataservice.ReceivingDataService;

public class ReceivingDataServiceImpl extends UnicastRemoteObject implements ReceivingDataService{

        private static final long serialVersionUID = -6643024262710089533L;
        
        private static final String PATH = "server/save/data/logistics/sendBillPO.dat";
        
        private ArrayList<SendBillPO> sendBillPOs;

        public ReceivingDataServiceImpl() throws RemoteException {
                super();
                init();
        }
        
        @SuppressWarnings("unchecked")
        private void init(){
                sendBillPOs = (ArrayList<SendBillPO>) Database.load(PATH);
                if(sendBillPOs == null)
                        sendBillPOs = new ArrayList<>();
        }

        @Override
        public ResultMessage insertBill(SendBillPO bill) throws RemoteException {
                init();
                for (SendBillPO sendBillPO : sendBillPOs) {
                      if(sendBillPO.getId().equals(bill.getId()))
                              return new ResultMessage("EXIST");
                }
                sendBillPOs.add(bill);
                Database.save(PATH, sendBillPOs);
                return new ResultMessage("SUCCESS");
        }

        @Override
        public ResultMessage findAll() throws RemoteException {
                ArrayList<SendBillPO> result = new ArrayList<>();
                init();
                result.addAll(sendBillPOs);
                return new ResultMessage("SUCCESS",result);
        }

}
