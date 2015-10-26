package main.bussinesslogicservice.infoblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import main.vo.SystemlogVO;

/**
 * @author zhuding
 *
 */
public class SystemlogMaintenanceBLService_Stub implements SystemlogMaintenanceBLService{

        @Override
        public ResultMessage addSystemlog(SystemlogVO systemlog) {
                // TODO Auto-generated method stub
                return new ResultMessage("add success!",null);
        }

        @Override
        public ResultMessage showSystemlog() {
                // TODO Auto-generated method stub
                return new ResultMessage("success!",null);
        }



}
