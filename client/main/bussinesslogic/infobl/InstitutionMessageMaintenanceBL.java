package main.bussinesslogic.infobl;

import java.rmi.RemoteException;

import po.InstitutionMessagePO;
import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import main.vo.InstitutionMessageVO;

public class InstitutionMessageMaintenanceBL implements
                InstitutionMessageMaintenanceBLService {

        private InstitutionMessageMaintenanceDataService institutionMessageMaintenanceDataService;

        public InstitutionMessageMaintenanceBL() {
                // TODO Auto-generated constructor stub
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
                if (resultMessage.getKey().equals("SUCCESS")) {
                        return new ResultMessage("SUCCESS",
                                        ((InstitutionMessagePO) resultMessage
                                                        .getValue()).poToVo());
                } else {
                        return new ResultMessage("FAIL");
                }
        }

}
