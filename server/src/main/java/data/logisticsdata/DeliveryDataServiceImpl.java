package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.Database;
import dataservice.logisticsdataservice.DeliveryDataService;
import po.GoodsPO;
import po.logisticpo.SendBillPO;

public class DeliveryDataServiceImpl extends UnicastRemoteObject implements DeliveryDataService{

        private static final long serialVersionUID = 7517528151328181814L;

        private static final String PATH = "src/main/java/save/logisticsdata/sendBillPO.dat";
        
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
                for (SendBillPO sendBillPO : sendBillPOs) {
                        if(sendBillPO.getId().equals(goodsPO.getId())){
                                sendBillPO.setGoodsPO(goodsPO);
                                System.out.println("updated!");
                        }
                }
                Database.save(PATH, sendBillPOs);
        }

}
