package bussinesslogic.infobl;

import bussinesslogicservice.infoblservice.StaffMessageMaintenanceBLService;
import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.StaffMessageMaintenanceDataService;
import po.StaffMessagePO;
import util.LogFactory;
import util.ResultMessage;
import vo.StaffMessageVO;
import vo.SystemlogVO;

import java.rmi.RemoteException;
import java.util.ArrayList;


public class StaffMessageMaintenanceBL implements StaffMessageMaintenanceBLService {

        private StaffMessageMaintenanceDataService staffMessageMaintenanceDataService;
        private SystemlogMaintenanceBLService service;
        
        public StaffMessageMaintenanceBL() {
                service = LogFactory.getInstance();
                staffMessageMaintenanceDataService = (StaffMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("StaffMessageMaintenanceDataServiceImpl");
        }
        
        @Override
        public ResultMessage addStaffMessage(StaffMessageVO staffMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = staffMessageMaintenanceDataService
                                        .insert(new StaffMessagePO(
                                                        staffMessage));
                        service.addSystemlog(new SystemlogVO("新增人员信息"));
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
                        service.addSystemlog(new SystemlogVO("删除人员信息"));
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
                        service.addSystemlog(new SystemlogVO("修改人员信息"));
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
                if (resultMessage.getKey().equals("FOUND")) {
                	service.addSystemlog(new SystemlogVO("查看人员信息"));
                        return new ResultMessage("SUCCESS",
                                        ((StaffMessagePO) resultMessage
                                                        .getValue()).poToVo());
                } else {
                        return new ResultMessage("FAIL");
                }
        }

		@Override
		public ResultMessage getStaff() {
			ResultMessage result;
			try {
				result = staffMessageMaintenanceDataService.getStaff();
				ArrayList<StaffMessagePO> pos = (ArrayList<StaffMessagePO>) result.getValue();
				ArrayList<StaffMessageVO> vos = new ArrayList<StaffMessageVO>();
				
				for(int i=0;i<pos.size();i++){
					vos.add(pos.get(i).poToVo());
				}
				
				service.addSystemlog(new SystemlogVO("查看所有人员信息"));
				return new ResultMessage("success", vos);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("FAIL");
			}
		}
}
