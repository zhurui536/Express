package main.bussinesslogicservice.infoblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.StaffMessageVO;

/**
 * @author zhuding
 *
 */
public interface StaffMessageMaintenanceBLService {
        public ResultMessage addStaffMessage(StaffMessageVO staffMessage);
        
        public ResultMessage delStaffMessage(long staffId);
        
        public ResultMessage modStaffMessage(StaffMessageVO staffMessage);
        
        public ResultMessage showStaffMessage(long staffId);
        
        public void endStaffMessageMaintenance();
}
