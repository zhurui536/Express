package bussinesslogic.infobl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import dataservice.infodataservice.StaffMessageMaintenanceDataService;
import po.InstitutionMessagePO;
import po.StaffMessagePO;
import util.ResultMessage;
import vo.InstitutionMessageVO;

public class InstitutionMessageMaintenanceBL implements
        InstitutionMessageMaintenanceBLService {

        private InstitutionMessageMaintenanceDataService institutionMessageMaintenanceDataService;
        private ArrayList<InstitutionMessagePO> pos;
		private StaffMessageMaintenanceDataService staffMessageMaintenanceDataService;

        public InstitutionMessageMaintenanceBL() {
                institutionMessageMaintenanceDataService = (InstitutionMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("InstitutionMessageMaintenanceDataServiceImpl");
                staffMessageMaintenanceDataService = (StaffMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("StaffMessageMaintenanceDataServiceImpl");
        }

        @Override
        public ResultMessage addInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = institutionMessageMaintenanceDataService
                                        .insert(new InstitutionMessagePO(
                                                        institutionMessage));
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage delInstitutionMessage(String institutionId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = institutionMessageMaintenanceDataService.delete(institutionId);
                        
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage modInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = institutionMessageMaintenanceDataService
                                        .update(new InstitutionMessagePO(
                                                        institutionMessage));
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage showInstitutionMessage(String institutionId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = institutionMessageMaintenanceDataService
                                        .find(institutionId);
                } catch (RemoteException e) {
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                if (resultMessage.getKey().equals("FOUND")) {
                        return new ResultMessage("SUCCESS",
                                        ((InstitutionMessagePO) resultMessage
                                                        .getValue()).poToVo());
                } else {
                        return new ResultMessage("FAIL");
                }
        }

		@SuppressWarnings("unchecked")
		@Override
		public ResultMessage getInstitutionMessage() {
			try {
				ResultMessage result = this.institutionMessageMaintenanceDataService.get();
				pos = (ArrayList<InstitutionMessagePO>) result.getValue();
				ArrayList<InstitutionMessageVO> vos = new ArrayList<InstitutionMessageVO>();
				
				for(int i=0;i<pos.size();i++){
					vos.add(pos.get(i).poToVo());
				}
				
				return new ResultMessage("SUCCESS", vos);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("FAIL");
			}
		}
		
		public ResultMessage delInstitution(ArrayList<StaffMessagePO> staffMessagePOs, String instid){
			for(int i=0;i<staffMessagePOs.size();i++){
				if(staffMessagePOs.get(i).getInstitutionid().equals(instid)){
					//如果有员工的机构被删除，则将机构id改为默认值
					staffMessagePOs.get(i).setInstitutionid("admin");
					try {
						staffMessageMaintenanceDataService.update(staffMessagePOs.get(i));
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
			return new ResultMessage("SUCCESS");
		}

}
