package main.bussinesslogic.infobl;

import java.rmi.RemoteException;

import po.DriverMessagePO;

import dataservice.infodataservice.DriverMessageMaintenanceDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.infoblservice.DriverMessageMaintenanceBLService;
import main.vo.DriverMessageVO;

public class DriverMessageMaintenanceBL implements
                DriverMessageMaintenanceBLService {

        private DriverMessageMaintenanceDataService driverMessageMaintenanceDataService;

        public DriverMessageMaintenanceBL() {
                // TODO Auto-generated constructor stub
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
                        return new ResultMessage("FAIL");
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
                        return new ResultMessage("FAIL");
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
                        return new ResultMessage("FAIL");
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
                        return new ResultMessage("FAIL");
                }
                if (resultMessage.getKey().equals("SUCCESS")) {
                        return new ResultMessage("SUCCESS",
                                        ((DriverMessagePO) resultMessage
                                                        .getValue()).poToVo());
                } else {
                        return new ResultMessage("FAIL");
                }
        }

}
