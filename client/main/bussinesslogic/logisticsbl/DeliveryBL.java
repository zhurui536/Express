package main.bussinesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsPO;
import dataservice.logisticsdataservice.DeliveryDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.DeliveryBLService;

public class DeliveryBL implements DeliveryBLService{

        private DeliveryDataService deliveryDataService;
        
        private ArrayList<GoodsPO> goodsPOsList;
        
        public DeliveryBL() {
                super();
//                this.deliveryDataService = deliveryDataService;
                goodsPOsList = new ArrayList<>();
        }

        @Override
        public ResultMessage addRecMessage(String Recipients, String id, long time) {
                GoodsPO goodsPO = null;
                try {
                        goodsPO = deliveryDataService.findGoods(id);
                } catch (RemoteException e) {
                        return new ResultMessage("NOT_FOUND", null);
                }
                goodsPO.setRecipient(Recipients);
                goodsPO.setReceiveTime(time);
                goodsPOsList.add(goodsPO);
               
                return new ResultMessage("SUCCESS", null);
        }

        @Override
        public void endDelivery() {
                for (GoodsPO goodsPO : goodsPOsList) {
                        try {
                                deliveryDataService.updateGoods(goodsPO);
                        } catch (RemoteException e) {
                                e.printStackTrace();
                        }
                }
                goodsPOsList.clear();
        }

}
