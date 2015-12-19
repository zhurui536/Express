package bussinesslogic.infobl;

import bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import po.InstitutionMessagePO;
import util.ResultMessage;
import vo.InstitutionMessageVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class InstitutionMessageMaintenanceBL implements
        InstitutionMessageMaintenanceBLService {

        private InstitutionMessageMaintenanceDataService institutionMessageMaintenanceDataService;

        public InstitutionMessageMaintenanceBL() {
                institutionMessageMaintenanceDataService = (InstitutionMessageMaintenanceDataService) ClientRMIHelper.getServiceByName("InstitutionMessageMaintenanceDataServiceImpl");
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
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return new ResultMessage("FAIL");
                }
                return new ResultMessage(resultMessage.getKey());
        }

        @Override
        public ResultMessage delInstitutionMessage(String institutionId) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = institutionMessageMaintenanceDataService
                                        .delete(institutionId);
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
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
                        // TODO Auto-generated catch block
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
                        // TODO Auto-generated catch block
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

		@Override
		public ResultMessage getInstitutionMessage() {
			try {
				ResultMessage result = this.institutionMessageMaintenanceDataService.get();
				ArrayList<InstitutionMessagePO> pos = (ArrayList<InstitutionMessagePO>) result.getValue();
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

}
