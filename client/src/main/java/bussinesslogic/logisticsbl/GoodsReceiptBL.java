package bussinesslogic.logisticsbl;

import bussinesslogicservice.logisticsblservice.GoodsReceiptBLService;
import connection.ClientRMIHelper;
import dataservice.logisticsdataservice.GoodsReceiptDataService;
import po.GoodsPO;
import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.TransferBillPO;
import util.InstitutionType;
import util.PublicMessage;
import util.ResultMessage;
import util.Time;
import vo.logisticvo.ArrivalBillVO;

import java.rmi.RemoteException;
import java.util.ArrayList;


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

                for (String goodsId : ids) {
                        GoodsPO goodsPO = null;
                        try {
                                goodsPO = goodsReceiptDataService.findGoods(goodsId);
                        } catch (RemoteException e) {
                                e.printStackTrace();
                        } 
                        goodsPO.addLocation(new Time().toString()
                                        + " "
                                        + PublicMessage.location
                                        + " "
                                        + InstitutionType
                                                        .typeTpString(PublicMessage.institutionType)
                                                        + " " + "已接收");
                        try {
                                goodsReceiptDataService.updateGoods(goodsPO);
                        } catch (RemoteException e) {
                                e.printStackTrace();
                        }
                }
                
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
                        goodsPO.addLocation(new Time().toString()
                                        + " 快递员 派件中");
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
