package main.bussinesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.logisticpo.LoadingBillPO;
import dataservice.logisticsdataservice.GoodsLoadDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.GoodsLoadBLService;
import main.vo.logisticvo.LoadingBillVO;

public class GoodsLoadBL implements GoodsLoadBLService{

        private GoodsLoadDataService goodsLoadDataService;
        
        //TODO
        //接口改动
        @Override
        public ResultMessage produceLoadBill(LoadingBillVO loadingBillVO) {
                try {
                        goodsLoadDataService.insertBill(LoadingBillPO.voToPo(loadingBillVO));
                } catch (RemoteException e) {
                        return new ResultMessage("INSERT_FAIL", null);
                }
                return new ResultMessage("SUCCESS",null);
        }

        @Override
        public void endGoodsLoad() {
                // TODO Auto-generated method stub
        }

        @Override
        public ResultMessage produceTransferBill() {
                // TODO Auto-generated method stub
                return null;
        }

}
