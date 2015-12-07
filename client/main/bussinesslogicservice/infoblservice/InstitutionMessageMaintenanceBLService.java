package main.bussinesslogicservice.infoblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.InstitutionMessageVO;

/**
 * @author zhuding
 *
 */
public interface InstitutionMessageMaintenanceBLService {
        public ResultMessage addInstitutionMessage(InstitutionMessageVO institutionMessage);
        
        public ResultMessage delInstitutionMessage(String institutionId);
        
        public ResultMessage modInstitutionMessage(InstitutionMessageVO institutionMessage);
        
        public ResultMessage showInstitutionMessage(String institutionId);
        
}
