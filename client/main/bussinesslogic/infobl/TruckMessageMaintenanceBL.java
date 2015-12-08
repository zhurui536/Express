package main.bussinesslogic.infobl;

import java.rmi.RemoteException;

import po.TruckMessagePO;
import dataservice.infodataservice.TruckMessageMaintenanceDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.infoblservice.TruckMessageMaintenanceBLService;
import main.connection.ClientRMIHelper;
import main.vo.TruckMessageVO;

public class TruckMessageMaintenanceBL implements TruckMessageMaintenanceBLService{

        private TruckMessageMaintenanceDataService truckMessageMaintenanceDataService;
        
        public TruckMessageMaintenanceBL() {
                truckMessageMaintenanceDataService = (TruckMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("TruckMessageMaintenanceDataServiceImpl");
        }
        
        @Override
        public ResultMessage addTruckMessage(TruckMessageVO truckMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = truckMessageMaintenanceDataService
                                        .insert(new TruckMessagePO(
                                                        truckMessage));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage delTruckMessage(String truckId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = truckMessageMaintenanceDataService
                                        .delete(truckId);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage modTruckMessage(TruckMessageVO truckMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = truckMessageMaintenanceDataService
                                        .update(new TruckMessagePO(
                                                        truckMessage));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage showTruckMessage(String truckId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = truckMessageMaintenanceDataService
                                        .find(truckId);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                if (resultMessage.getKey().equals("SUCCESS")) {
                        return new ResultMessage("SUCCESS",
                                        ((TruckMessagePO) resultMessage
                                                        .getValue()).poToVo());
                } else {
                        return new ResultMessage("FAIL");
                }
        }

}
