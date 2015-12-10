package bussinesslogic.infobl;

import bussinesslogicservice.infoblservice.StaffMessageMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.StaffMessageMaintenanceDataService;
import po.StaffMessagePO;
import util.ResultMessage;
import vo.StaffMessageVO;

import java.rmi.RemoteException;


public class StaffMessageMaintenanceBL implements StaffMessageMaintenanceBLService {

        private StaffMessageMaintenanceDataService staffMessageMaintenanceDataService;
        
        public StaffMessageMaintenanceBL() {
                staffMessageMaintenanceDataService = (StaffMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("StaffMessageMaintenanceDataServiceImpl");
        }
        
        @Override
        public ResultMessage addStaffMessage(StaffMessageVO staffMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = staffMessageMaintenanceDataService
                                        .insert(new StaffMessagePO(
                                                        staffMessage));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage delStaffMessage(String staffId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = staffMessageMaintenanceDataService
                                        .delete(staffId);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage modStaffMessage(StaffMessageVO staffMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = staffMessageMaintenanceDataService
                                        .update(new StaffMessagePO(
                                                        staffMessage));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage showStaffMessage(String staffId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = staffMessageMaintenanceDataService
                                        .find(staffId);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                if (resultMessage.getKey().equals("SUCCESS")) {
                        return new ResultMessage("SUCCESS",
                                        ((StaffMessagePO) resultMessage
                                                        .getValue()).poToVo());
                } else {
                        return new ResultMessage("FAIL");
                }
        }

}