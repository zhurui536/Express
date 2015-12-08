package main.bussinesslogic.logisticsbl;


import java.rmi.RemoteException;
import java.util.ArrayList;

import po.GoodsPO;
import po.logisticpo.SendBillPO;
import dataservice.logisticsdataservice.ReceivingDataService;
import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;
import main.bussinesslogic.util.PublicMessage;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.ReceivingBLService;
import main.connection.ClientRMIHelper;
import main.vo.GoodsVO;
import main.vo.logisticvo.SendBillVO;

public class ReceivingBL implements ReceivingBLService{

        private ReceivingDataService receivingDataService;
        
        private ArrayList<SendBillPO> sendBillPOs;
        
        public ReceivingBL() {
                this.sendBillPOs = new ArrayList<>();
                receivingDataService = (ReceivingDataService) ClientRMIHelper.getServiceByName("ReceivingDataServiceImpl");
        }
        
        @Override
        public ResultMessage addMessage(SendBillVO billVO) {
                SendBillPO sendBillPO = SendBillPO.voToPo(billVO);
                GoodsVO goodsVO = billVO.goodsVO;
                goodsVO.price = getCharge(goodsVO);
                GoodsPO goodsPO = GoodsPO.voToPo(goodsVO);
                goodsPO.addLocation(PublicMessage.location);
                sendBillPO.setGoodsPO(goodsPO);
                sendBillPOs.add(sendBillPO);
                return new ResultMessage("SUCCESS", null);
        }

        @SuppressWarnings("unchecked")
        @Override
        public long getTime(String departurePlace, String destination) {
                ArrayList<SendBillPO> sendBillPOs = null;
                try {
                        sendBillPOs = (ArrayList<SendBillPO>) (receivingDataService.findAll()).getValue();
                } catch (RemoteException e) {
                        return -1;
                }
                if(sendBillPOs == null)
                        return 0;
                //TODO
                long sum = 0;
                long count = 0;
                for (SendBillPO sendBillPO : sendBillPOs) {
                        GoodsPO goodsPO = sendBillPO.getGoodsPO();
                        if (goodsPO.getDeparturePlace().equals(departurePlace)
                                        && destination.equals(goodsPO
                                                        .getDestination())) {
                                sum += (goodsPO.getReceiveTime().sub(goodsPO
                                                .getStartTime()));
                                count++;
                        }
                }
                return sum / count;
        }

        @Override
        public double getCharge(GoodsVO goods) {
                int tempDistance = 900;
                //TODO
                //在数据层拿到distance的数据
                return PackageType.typeToCost(goods.packageType)
                                + goods.weight
                                * ExpressType.typeToCost(goods.expressType,
                                                tempDistance);
        }

        @Override
        public void endReceipt() {
                for (SendBillPO sendBillPO : sendBillPOs) {
                        try {
                                receivingDataService.insertBill(sendBillPO);
                        } catch (RemoteException e) {
                                e.printStackTrace();
                        }
                }
                sendBillPOs.clear();
        }

}
