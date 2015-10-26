package main.bussinesslogicservice.infoblservice;

import main.bussinesslogic.util.ResultMessage;
import main.vo.DriverMessageVO;

/**
 * @author zhuding
 *
 */
public interface DriverMessageMaintenanceBLService {
        public ResultMessage addDriverMessage(DriverMessageVO driverMessage);
        
        public ResultMessage delDriverMessage(String driverId);
        //long to String
        public ResultMessage modDriverMessage(DriverMessageVO driverMessage);
        
        public ResultMessage showDriverMessage(String driverId);
        
        public void endDriverMessageMaintenance();
}
