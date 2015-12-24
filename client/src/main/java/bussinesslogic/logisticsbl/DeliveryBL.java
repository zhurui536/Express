package bussinesslogic.logisticsbl;

import bussinesslogicservice.logisticsblservice.DeliveryBLService;
import connection.ClientRMIHelper;
import dataservice.logisticsdataservice.DeliveryDataService;
import po.GoodsPO;
import util.GoodsDeliveryState;
import util.ResultMessage;
import util.Time;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class DeliveryBL implements DeliveryBLService {

        private DeliveryDataService deliveryDataService;
        
        private ArrayList<GoodsPO> goodsPOsList;
        
        public DeliveryBL() {
                super();
                ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
                deliveryDataService = (DeliveryDataService) clientRMIHelper.getServiceByName("DeliveryDataServiceImpl");
                goodsPOsList = new ArrayList<>();
        }

        @Override
        public ResultMessage addRecMessage(String Recipients, String id, Time time) {
                GoodsPO goodsPO = null;
                try {
                        goodsPO = deliveryDataService.findGoods(id);
                } catch (RemoteException e) {
                        return new ResultMessage("NOT_FOUND", null);
                }
                if (goodsPO == null) {
                        return new ResultMessage("NOT_FOUND", null);
                }
                goodsPO.setRecipient(Recipients);
                goodsPO.setReceiveTime(time);
                goodsPO.setGoodsDeliveryState(GoodsDeliveryState.DELIVERED);
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
