package main.bussinesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.GoodsPO;
import dataservice.logisticsdataservice.DeliveryDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.DeliveryBLService;

public class DeliveryBL implements DeliveryBLService{

        private DeliveryDataService deliveryDataService;
        
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
                try {
                        deliveryDataService.updateGoods(goodsPO);
                } catch (RemoteException e) {
                        return new ResultMessage("NOT_FOUND", null);
                }
                return new ResultMessage("SUCCESS", null);
        }

        @Override
        public void endDelivery() {
                // TODO Auto-generated method stub
        }

}
