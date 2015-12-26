package bussinesslogic.infobl;

import bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import connection.ClientRMIHelper;
import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import po.InstitutionMessagePO;
import util.LogFactory;
import util.ResultMessage;
import vo.InstitutionMessageVO;
import vo.SystemlogVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class InstitutionMessageMaintenanceBL implements
        InstitutionMessageMaintenanceBLService {

        private InstitutionMessageMaintenanceDataService institutionMessageMaintenanceDataService;
        private SystemlogMaintenanceBLService service;
        private ArrayList<InstitutionMessagePO> pos;

        public InstitutionMessageMaintenanceBL() {
                ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
                service = LogFactory.getInstance();
                institutionMessageMaintenanceDataService = (InstitutionMessageMaintenanceDataService) clientRMIHelper.getServiceByName("InstitutionMessageMaintenanceDataServiceImpl");
        }

        @Override
        public ResultMessage addInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                ResultMessage resultMessage = null;
                try {
                        resultMessage = institutionMessageMaintenanceDataService
                                        .insert(new InstitutionMessagePO(
                                                        institutionMessage));
                        service.addSystemlog(new SystemlogVO("新增机构信息"));
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
                        service.addSystemlog(new SystemlogVO("删除机构信息"));
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
                        service.addSystemlog(new SystemlogVO("修改人员信息"));
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
                	service.addSystemlog(new SystemlogVO("查看机构信息"));
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
				pos = (ArrayList<InstitutionMessagePO>) result.getValue();
				ArrayList<InstitutionMessageVO> vos = new ArrayList<InstitutionMessageVO>();
				
				for(int i=0;i<pos.size();i++){
					vos.add(pos.get(i).poToVo());
				}
				
				service.addSystemlog(new SystemlogVO("查看所有机构信息"));
				return new ResultMessage("SUCCESS", vos);
			} catch (RemoteException e) {
				e.printStackTrace();
				return new ResultMessage("FAIL");
			}
		}

}
