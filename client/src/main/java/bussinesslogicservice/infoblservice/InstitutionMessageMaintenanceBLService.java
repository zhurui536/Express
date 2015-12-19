package bussinesslogicservice.infoblservice;

import util.ResultMessage;
import vo.InstitutionMessageVO;

/**
 * @author zhuding
 *
 */
public interface InstitutionMessageMaintenanceBLService {
        public ResultMessage addInstitutionMessage(InstitutionMessageVO institutionMessage);
        
        public ResultMessage delInstitutionMessage(String institutionId);
        
        public ResultMessage modInstitutionMessage(InstitutionMessageVO institutionMessage);
        
        public ResultMessage showInstitutionMessage(String institutionId);
        
        public ResultMessage getInstitutionMessage();
}
