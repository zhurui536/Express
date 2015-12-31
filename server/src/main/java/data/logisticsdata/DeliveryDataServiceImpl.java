package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.logisticsdataservice.DeliveryDataService;
import po.GoodsPO;
import po.logisticpo.SendBillPO;
import serialutility.Database;

public class DeliveryDataServiceImpl extends UnicastRemoteObject implements DeliveryDataService{

        private static final long serialVersionUID = 7517528151328181814L;

        private static final String PATH = "save/logisticsdata/sendBillPO.dat";
        
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
                init();
                for (SendBillPO sendBillPO : sendBillPOs) {
                        if(sendBillPO.getId().equals(id)){
                                return sendBillPO.getGoodsPO();
                        }
                }
                return null;
        }

        @Override
        public void updateGoods(GoodsPO goodsPO) throws RemoteException {
        		init();
                for (SendBillPO sendBillPO : sendBillPOs) {
                	System.out.println(sendBillPO.getId()+" "+sendBillPO.getGoodsPO().getId());
                        if(sendBillPO.getId().equals(goodsPO.getId())){
                                sendBillPO.setGoodsPO(goodsPO);
                        }
                }
                Database.save(PATH, sendBillPOs);
        }

}
