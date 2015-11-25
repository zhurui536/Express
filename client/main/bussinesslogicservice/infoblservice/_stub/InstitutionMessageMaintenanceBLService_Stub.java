package main.bussinesslogicservice.infoblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import main.vo.InstitutionMessageVO;

/**
 * @author zhuding
 *
 */
public class InstitutionMessageMaintenanceBLService_Stub implements InstitutionMessageMaintenanceBLService{

        @Override
        public ResultMessage addInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                // TODO Auto-generated method stub
                return new ResultMessage("add success!",null);
        }

        @Override
        public ResultMessage delInstitutionMessage(long institutionId) {
                // TODO Auto-generated method stub
                return new ResultMessage("del success!",null);
        }

        @Override
        public ResultMessage modInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                // TODO Auto-generated method stub
                return new ResultMessage("mod success!",null);
        }

        @Override
        public ResultMessage showInstitutionMessage(long institutionId) {
                // TODO Auto-generated method stub
                return new ResultMessage("success!",null);
        }

        @Override
        public void endInstitutionMessageMaintenance() {
                // TODO Auto-generated method stub
                System.out.println("SUCCESS!");
        }

}
