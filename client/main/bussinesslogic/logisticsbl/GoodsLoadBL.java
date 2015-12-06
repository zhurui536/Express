package main.bussinesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.logisticpo.LoadingBillPO;
import po.logisticpo.TransferBillPO;
import dataservice.logisticsdataservice.GoodsLoadDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.GoodsLoadBLService;
import main.vo.logisticvo.LoadingBillVO;
import main.vo.logisticvo.TransferBillVO;

public class GoodsLoadBL implements GoodsLoadBLService {

        private GoodsLoadDataService goodsLoadDataService;

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
        public void endGoodsLoad() {
                // TODO Auto-generated method stub
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
                // TODO 调出库的方法
                return new ResultMessage("SUCCESS");
        }

}
