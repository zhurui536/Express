package main.data.logisticsdata;

import dataservice.logisticsdataservice.DeliveryDataService;
import main.dao.Database;
import po.GoodsPO;
import po.logisticpo.SendBillPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DeliveryDataServiceImpl extends UnicastRemoteObject implements DeliveryDataService{

        private static final long serialVersionUID = 7517528151328181814L;

        private static final String PATH = "server/src/main/java/save/logisticsdata/sendBillPO.dat";
        
        private ArrayList<SendBillPO> sendBillPOs;
        
        public DeliveryDataServiceImpl() throws RemoteException {
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
        public GoodsPO findGoods(String id) throws RemoteException {
                for (SendBillPO sendBillPO : sendBillPOs) {
                        if(sendBillPO.getId().equals(id)){
                                return sendBillPO.getGoodsPO();
                        }
                }
                return null;
        }

        @Override
        public void updateGoods(GoodsPO goodsPO) throws RemoteException {
                for (SendBillPO sendBillPO : sendBillPOs) {
                        if(sendBillPO.getId().equals(goodsPO.getId())){
                                sendBillPO.setGoodsPO(goodsPO);
                        }
                }
                Database.save(PATH, sendBillPOs);
        }

}
