package bussinesslogic.infobl;

import bussinesslogicservice.infoblservice.DriverMessageMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.DriverMessageMaintenanceDataService;
import po.DriverMessagePO;
import util.ResultMessage;
import vo.DriverMessageVO;

import java.rmi.RemoteException;

public class DriverMessageMaintenanceBL implements
        DriverMessageMaintenanceBLService {

        private DriverMessageMaintenanceDataService driverMessageMaintenanceDataService;

        public DriverMessageMaintenanceBL() {
                driverMessageMaintenanceDataService = (DriverMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("DriverMessageMaintenanceDataServiceImpl");
        }

        @Override
        public ResultMessage addDriverMessage(DriverMessageVO driverMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = driverMessageMaintenanceDataService
                                        .insert(new DriverMessagePO(
                                                        driverMessage));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("internet error");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage delDriverMessage(String driverId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = driverMessageMaintenanceDataService
                                        .delete(driverId);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("internet error");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage modDriverMessage(DriverMessageVO driverMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = driverMessageMaintenanceDataService
                                        .update(new DriverMessagePO(
                                                        driverMessage));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("internet error");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage showDriverMessage(String driverId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = driverMessageMaintenanceDataService
                                        .find(driverId);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("internet error");
                }
                if (resultMessage.getKey().equals("FOUND")) {
                        return new ResultMessage("SUCCESS",
                                        ((DriverMessagePO) resultMessage
                                                        .getValue()).poToVo());
                } else {
                        return new ResultMessage("FAIL");
                }
        }

}
