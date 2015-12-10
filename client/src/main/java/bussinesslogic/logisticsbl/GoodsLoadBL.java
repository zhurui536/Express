package bussinesslogic.logisticsbl;

import bussinesslogicservice.logisticsblservice.GoodsLoadBLService;
import connection.ClientRMIHelper;
import dataservice.logisticsdataservice.GoodsLoadDataService;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.TransferBillPO;
import util.ResultMessage;
import vo.logisticvo.LoadingBillVO;
import vo.logisticvo.TransferBillVO;

import java.rmi.RemoteException;

public class GoodsLoadBL implements GoodsLoadBLService {

        private GoodsLoadDataService goodsLoadDataService;


        public GoodsLoadBL() {
                goodsLoadDataService = (GoodsLoadDataService) ClientRMIHelper.getServiceByName("GoodsLoadDataServiceImpl");
        }

        // TODO
        // 接口改动
        @Override
        public ResultMessage produceLoadBill(LoadingBillVO loadingBillVO) {
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
