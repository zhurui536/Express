package bussinesslogic.infobl;

import bussinesslogicservice.infoblservice.TruckMessageMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.TruckMessageMaintenanceDataService;
import po.TruckMessagePO;
import util.ResultMessage;
import vo.TruckMessageVO;

import java.rmi.RemoteException;

public class TruckMessageMaintenanceBL implements TruckMessageMaintenanceBLService {

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
