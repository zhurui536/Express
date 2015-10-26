package main.bussinesslogicservice.infoblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.DriverMessageVO;

/**
 * @author zhuding
 *
 */
public interface DriverMessageMaintenanceBLService {
        public ResultMessage addDriverMessage(DriverMessageVO driverMessage);
        
        public ResultMessage delDriverMessage(long driverId);
        
        public ResultMessage modDriverMessage(DriverMessageVO driverMessage);
        
        public ResultMessage showDriverMessage(long driverId);
        
        public void endDriverMessageMaintenance();
}
