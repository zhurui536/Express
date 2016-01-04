package bussinesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.logisticsblservice.GoodsLoadBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.TruckMessageMaintenanceDataService;
import dataservice.logisticsdataservice.BillQueryDataService;
import dataservice.logisticsdataservice.GoodsLoadDataService;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.SendBillPO;
import po.logisticpo.TransferBillPO;
import util.BillState;
import util.InstitutionType;
import util.PublicMessage;
import util.ResultMessage;
import util.Time;
import vo.logisticvo.LoadingBillVO;
import vo.logisticvo.TransferBillVO;

public class GoodsLoadBL implements GoodsLoadBLService {

        private GoodsLoadDataService goodsLoadDataService;
        private BillQueryDataService goodsdata;
        private TruckMessageMaintenanceDataService truckdata;

        public GoodsLoadBL() {
                goodsLoadDataService = (GoodsLoadDataService) ClientRMIHelper.getServiceByName("GoodsLoadDataServiceImpl");
                goodsdata = (BillQueryDataService) ClientRMIHelper.getServiceByName("BillQueryDataServiceImpl");
                truckdata = (TruckMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("TruckMessageMaintenanceDataServiceImpl");
        }

        @SuppressWarnings("unchecked")
        // 接口改动
        @Override
        public ResultMessage produceLoadBill(LoadingBillVO loadingBillVO) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = goodsLoadDataService.findSendBills(loadingBillVO.ids);
                } catch (RemoteException e1) {
                        e1.printStackTrace();
                        return new ResultMessage("internet error");
                }
                ArrayList<SendBillPO> sendBillPOs = null;
                //更新货物的货运状态
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
                                return new ResultMessage("internet error");
                        }
                }
                        
                try {
                	//保存装车单
                	LoadingBillPO bill = LoadingBillPO.voToPo(loadingBillVO);
                	bill.setState(BillState.SUBMTTED);
                        goodsLoadDataService.insertBill(bill);
                } catch (RemoteException e) {
                        return new ResultMessage("internet error", null);
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
                transferBillPO.setState(BillState.SUBMTTED);
                try {
                        goodsLoadDataService.insertBill(transferBillPO);
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL_INSERT");
                }


                return new ResultMessage("SUCCESS");
        }

		@Override
		public ResultMessage addGoods(String id) {
			SendBillPO goods;
			try {
				goods = this.goodsdata.findBill(id);
				if(goods == null){
					return new ResultMessage("nogoods");
				}
				else{
					return new ResultMessage("exist");
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error");
			}
		}

		@Override
		public ResultMessage checkTruck(String id) {
			ResultMessage result;
			try {
				result = truckdata.find(id);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("internet error");
			}
			if(result.getKey().equals("FOUND")){
				return result;
			}
			else{
				return result;
			}
		}
		
		
}
