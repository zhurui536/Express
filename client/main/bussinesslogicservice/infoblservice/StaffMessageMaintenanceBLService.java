package main.bussinesslogicservice.infoblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.StaffMessageVO;

/**
 * @author zhuding
 *
 */
public interface StaffMessageMaintenanceBLService {
        /**
         * 增加员工信息时调用
         * @param staffMessage 新的员工信息的VO
         * @return
         */
        public ResultMessage addStaffMessage(StaffMessageVO staffMessage);
        /**
         * 删除员工信息时调用
         * @param staffId 删除的员工的ID
         * @return
         */
        public ResultMessage delStaffMessage(String staffId);
        /**
         * 修改员工信息时调用
         * @param staffMessage 修改后员工信息的VO
         * @return
         */
        public ResultMessage modStaffMessage(StaffMessageVO staffMessage);
        /**
         * 查看员工信息时调用
         * @param staffId 员工的ID
         * @return 包含员工信息的VO的ResultMessage(如果成功找到)
         */
        public ResultMessage showStaffMessage(String staffId);
        
}
