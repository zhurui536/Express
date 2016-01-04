package bussinesslogic.infobl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.infoblservice.TruckMessageMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.TruckMessageMaintenanceDataService;
import po.TruckMessagePO;
import util.PublicMessage;
import util.ResultMessage;
import vo.TruckMessageVO;

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
        public ResultMessage getTruckMessage(String truckId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = truckMessageMaintenanceDataService
                                        .find(truckId);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                if (resultMessage.getKey().equals("FOUND")) {
                        return new ResultMessage("SUCCESS",
                                        ((TruckMessagePO) resultMessage
                                                        .getValue()).poToVo());
                } else {
                        return new ResultMessage("FAIL");
                }
        }

        @SuppressWarnings("unchecked")
        @Override
        public ResultMessage showAllTruckMessage() {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = truckMessageMaintenanceDataService.findAll(PublicMessage.institutionID);
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("internet error");
                }
                ArrayList<TruckMessageVO> truckMessageVOs = new ArrayList<>();
                for (TruckMessagePO truckMessagePO : (ArrayList<TruckMessagePO>)resultMessage.getValue()) {
                        truckMessageVOs.add(truckMessagePO.poToVo());
                }
                return new ResultMessage("success",truckMessageVOs);
        }

}
