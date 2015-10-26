package main.bussinesslogicservice.infoblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.SystemlogVO;

/**
 * @author zhuding
 *
 */
public interface SystemlogMaintenanceBLService {
        public ResultMessage addSystemlog(SystemlogVO systemlog);
        
        public ResultMessage showSystemlog();
}
