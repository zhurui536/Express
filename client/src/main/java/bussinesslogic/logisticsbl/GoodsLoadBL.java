package bussinesslogic.logisticsbl;

import bussinesslogicservice.logisticsblservice.GoodsLoadBLService;
import connection.ClientRMIHelper;
import dataservice.logisticsdataservice.GoodsLoadDataService;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.SendBillPO;
import po.logisticpo.TransferBillPO;
import util.InstitutionType;
import util.PublicMessage;
import util.ResultMessage;
import util.Time;
import vo.logisticvo.LoadingBillVO;
import vo.logisticvo.TransferBillVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class GoodsLoadBL implements GoodsLoadBLService {

        private GoodsLoadDataService goodsLoadDataService;


        public GoodsLoadBL() {
                goodsLoadDataService = (GoodsLoadDataService) ClientRMIHelper.getServiceByName("GoodsLoadDataServiceImpl");
        }

        // TODO
        @SuppressWarnings("unchecked")
        // 接口改动
        @Override
        public ResultMessage produceLoadBill(LoadingBillVO loadingBillVO) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = goodsLoadDataService.findSendBills(loadingBillVO.ids);
                } catch (RemoteException e1) {
                        e1.printStackTrace();
                        return new ResultMessage("internet_error");
                }
                ArrayList<SendBillPO> sendBillPOs = null;
                if(resultMessage.getKey().equals("success")){
                        sendBillPOs = (ArrayList<SendBillPO>) resultMessage.getValue();
                        for (SendBillPO sendBillPO : sendBillPOs) {
                                sendBillPO.getGoodsPO().addLocation(new Time().toString()
                                                + " "
                                                + PublicMessage.location
                                                + " "
                                                + InstitutionType
                                                                .typeTpString(PublicMessage.institutionType)
                                                                + " " + "已装车");
                        }
                        try {
                                goodsLoadDataService.updateSendBills(sendBillPOs);
                        } catch (RemoteException e) {
                                e.printStackTrace();
                                return new ResultMessage("internet_error");
                        }
                }
                        
                try {
                        goodsLoadDataService.insertBill(LoadingBillPO
                                .voToPo(loadingBillVO));
                } catch (RemoteException e) {
                        return new ResultMessage("INSERT_FAIL", null);
                }
                return new ResultMessage("SUCCESS", null);
        }

        @Override
        public ResultMessage produceTransferBill(TransferBillVO transferBillVO) {
                TransferBillPO transferBillPO = new TransferBillPO(
                        transferBillVO.transferBillNum,
                        transferBillVO.trans,
                        transferBillVO.depaturePlace,
                        transferBillVO.arrivalPlace, transferBillVO.ids);
                transferBillPO.setNumber(transferBillVO.number);
                transferBillPO.setNumOfLoc(transferBillVO.numOfLoc);
                transferBillPO.setCharge(transferBillVO.charge);
                transferBillPO.setSupercargo(transferBillVO.supercargo);
                transferBillPO.setSupervisor(transferBillVO.supervisor);
                try {
                        goodsLoadDataService.insertBill(transferBillPO);
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL_INSERT");
                }


                return new ResultMessage("SUCCESS");
        }

}
