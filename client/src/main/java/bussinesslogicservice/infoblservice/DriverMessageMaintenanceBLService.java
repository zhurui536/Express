package bussinesslogicservice.infoblservice;

import util.ResultMessage;
import vo.DriverMessageVO;

/**
 * @author zhuding
 *
 */
public interface DriverMessageMaintenanceBLService {
        /**
         * 增加司机信息时调用
         * @param driverMessage 新的司机信息的VO
         * @return
         */
        public ResultMessage addDriverMessage(DriverMessageVO driverMessage);
        
        /**
         * 删除司机信息时调用
         * @param driverId 删除的司机的ID
         * @return
         */
        public ResultMessage delDriverMessage(String driverId);
        
        /**
         * 修改司机信息时调用
         * @param driverMessage 修改后司机信息的VO
         * @return
         */
        public ResultMessage modDriverMessage(DriverMessageVO driverMessage);
        
        /**
         * 查看司机信息时调用
         * @param driverId 司机的ID
         * @return 包含司机信息的VO的ResultMessage(如果成功找到)
         */
        public ResultMessage getDriverMessage(String driverId);
        
        public ResultMessage showAllDriverMessage();
        
}
