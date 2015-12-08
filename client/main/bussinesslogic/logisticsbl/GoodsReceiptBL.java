package main.bussinesslogic.logisticsbl;

import java.util.ArrayList;

import java.rmi.RemoteException;

import po.GoodsPO;
import po.logisticpo.*;

import dataservice.logisticsdataservice.GoodsReceiptDataService;
import main.bussinesslogic.util.*;
import main.bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import main.connection.ClientRMIHelper;
import main.vo.logisticvo.ArrivalBillVO;

public class GoodsReceiptBL implements GoodsReceiptBLService {

        private GoodsReceiptDataService goodsReceiptDataService;

        private ArrayList<String> ids;

        public GoodsReceiptBL() {
                ids = new ArrayList<>();
                goodsReceiptDataService = (GoodsReceiptDataService) ClientRMIHelper.getServiceByName("GoodsReceiptDataServiceImpl");
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

                if (resultMessage == null
                                || resultMessage.getKey().equals("NOT_FOUND"))
                        return new ResultMessage("FAIL");

                LoadingBillPO loadingBillPO = null;
                TransferBillPO transferBillPO = null;
                if (resultMessage.getKey().equals("FOUND_LoadingBill")) {
                        loadingBillPO = (LoadingBillPO) resultMessage
                                        .getValue();
                } else if (resultMessage.getKey().equals("FOUND_TransferBill")) {
                        transferBillPO = (TransferBillPO) resultMessage
                                        .getValue();
                }
                ids = loadingBillPO == null ? transferBillPO.getIds()
                                : loadingBillPO.getIds();

                ArrivalBillPO arrivalBillPO = new ArrivalBillPO(
                                arrivalBillVO.institution, arrivalBillVO.date,
                                arrivalBillVO.transferBillNum,
                                arrivalBillVO.departurePlace,
                                arrivalBillVO.goodsState);
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
                        } 
                        goodsPO.addLocation(PublicMessage.location);
                        try {
                                goodsReceiptDataService.updateGoods(goodsPO);
                        } catch (RemoteException e) {
                                e.printStackTrace();
                        }
                }
                DeliveryBillPO deliveryBillPO = new DeliveryBillPO(new Time(),
                                ids, deliverManId);
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
