package main.bussinesslogic.logisticsbl;


import java.util.ArrayList;

import java.rmi.RemoteException;

import po.GoodsPO;
import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.TransferBillPO;

import dataservice.logisticsdataservice.GoodsReceiptDataService;
import main.bussinesslogic.util.PublicMessage;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import main.vo.logisticvo.ArrivalBillVO;

public class GoodsReceiptBL implements GoodsReceiptBLService{

        private GoodsReceiptDataService goodsReceiptDataService;
        
        private ArrayList<String> ids;
        
        public GoodsReceiptBL() {
                ids = new ArrayList<>();
                // TODO Auto-generated constructor stub
        }

        @Override
        public ResultMessage produceArrivalBill(ArrivalBillVO arrivalBillVO) {
                String id = arrivalBillVO.transferBillNum;
                ResultMessage resultMessage = null;
                try {
                        resultMessage = goodsReceiptDataService.findBill(id);
                } catch (RemoteException e) {
                        e.printStackTrace();
                }
                
                if(resultMessage == null || !resultMessage.getKey().equals("SUCCESS"))
                        return new ResultMessage("FAIL");
                
                String location = PublicMessage.location;
                LoadingBillPO loadingBillPO = null;
                TransferBillPO transferBillPO = null;
                if(location.equals(arrivalBillVO.departurePlace)){
                        loadingBillPO = (LoadingBillPO) resultMessage.getValue();
                }
                else {
                        transferBillPO = (TransferBillPO) resultMessage.getValue();
                }
                ids = loadingBillPO == null ? transferBillPO.getIds() : loadingBillPO.getIds();
                //TODO 入库操作
                ArrivalBillPO arrivalBillPO = new ArrivalBillPO(arrivalBillVO.institution, arrivalBillVO.date, arrivalBillVO.transferBillNum, arrivalBillVO.departurePlace, arrivalBillVO.goodsState);
                try {
                        goodsReceiptDataService.insertBill(arrivalBillPO);
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL_TO_INSERT");
                }
                
                return new ResultMessage("SUCCESS");
        }

        @Override
        public ResultMessage produceDeliveryBill(String deliverManId) {
                for (String id : ids) {
                        GoodsPO goodsPO = null;
                        try {
                                goodsPO = goodsReceiptDataService.findGoods(id);
                        } catch (RemoteException e) {
                                e.printStackTrace();
//                                return new Re
                        }
                        goodsPO.addLocation(PublicMessage.location);
                        try {
                                goodsReceiptDataService.updateGoods(goodsPO);
                        } catch (RemoteException e) {
                                e.printStackTrace();
                        }
                }
                DeliveryBillPO deliveryBillPO = new DeliveryBillPO(new Time(), ids, deliverManId);
                try {
                        goodsReceiptDataService.insertBill(deliveryBillPO);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                endGoodsreceipt();
                return new ResultMessage("SUCCESS");
        }

        
        @Override
        public void endGoodsreceipt() {
                ids.clear();
        }

}
