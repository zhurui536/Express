package bussinesslogicservice.infoblservice;

import util.ResultMessage;
import vo.SystemlogVO;

/**
 * @author zhuding
 *
 */
public interface SystemlogMaintenanceBLService {
        public ResultMessage addSystemlog(SystemlogVO systemlog);
        
        public ResultMessage showSystemlog();
}
