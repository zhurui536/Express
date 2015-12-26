package bussinesslogic.logisticsbl;


import bussinesslogicservice.logisticsblservice.ReceivingBLService;
import connection.ClientRMIHelper;
import dataservice.logisticsdataservice.ReceivingDataService;
import dataservice.strategydataservice.StrategyDataService;
import po.DistancePO;
import po.GoodsPO;
import po.logisticpo.SendBillPO;
import util.*;
import vo.GoodsVO;
import vo.logisticvo.SendBillVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ReceivingBL implements ReceivingBLService {

        private ReceivingDataService receivingDataService;
        
        private StrategyDataService strategyDataService;
        
        private ArrayList<SendBillPO> sendBillPOs;
        
        public ReceivingBL() {
                this.sendBillPOs = new ArrayList<>();
                receivingDataService = (ReceivingDataService) ClientRMIHelper.getServiceByName("ReceivingDataServiceImpl");
                strategyDataService = (StrategyDataService) ClientRMIHelper.getServiceByName("StrategyDataServiceImpl");
        }
        
        @Override
        public ResultMessage addMessage(SendBillVO billVO) {
                SendBillPO sendBillPO = SendBillPO.voToPo(billVO);
                GoodsVO goodsVO = billVO.goodsVO;
                goodsVO.price = getCharge(goodsVO);
                GoodsPO goodsPO = GoodsPO.voToPo(goodsVO);
                goodsPO.addLocation(new Time().toString()
                                + " "
                                + PublicMessage.location
                                + " "
                                + InstitutionType
                                                .typeTpString(PublicMessage.institutionType)
                                                + " " + "已收件");
                sendBillPO.setGoodsPO(goodsPO);
                sendBillPOs.add(sendBillPO);
                try {
                        receivingDataService.insertBill(sendBillPO);
                } catch (RemoteException e) {
                        e.printStackTrace();
                }
                return new ResultMessage("SUCCESS", billVO);
        }

        @SuppressWarnings("unchecked")
        @Override
        public long getTime(City departurePlace, City destination) {
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

                if(count==0){
                	return 0;
                }
                return sum / count;

        }

        @Override
        public double getCharge(GoodsVO goods) {
                double distance = 0;
                ResultMessage resultMessage = null;
                try {
                        resultMessage = strategyDataService.getDistance();
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                @SuppressWarnings("unchecked")
                ArrayList<DistancePO> distancePos = (ArrayList<DistancePO>) resultMessage.getValue();
                for (DistancePO distancePO : distancePos) {
                        if(distancePO.ifMatch(goods.departurePlace, goods.destination)){
                                distance = distancePO.getDistance();
                        }
                }
                return PackageType.typeToCost(goods.packageType)
                                + goods.weight
                                * ExpressType.typeToCost(goods.expressType,
                        distance);
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
