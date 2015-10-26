package main.bussinesslogicservice.infoblservice._driver;

import main.bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import main.bussinesslogicservice.infoblservice._stub.SystemlogMaintenanceBLService_Stub;
import main.vo.SystemlogVO;

/**
 * @author zhuding
 *
 */
public class SystemlogMaintenanceBLService_Driver {
private SystemlogMaintenanceBLService systemlogMaintenanceBLService;
        
        public static void main(String[] args) {
                SystemlogMaintenanceBLService systemlogMaintenanceBLService = new SystemlogMaintenanceBLService_Stub();
                SystemlogMaintenanceBLService_Driver driver = new SystemlogMaintenanceBLService_Driver(systemlogMaintenanceBLService);
                driver.drive();
        }
        
        public SystemlogMaintenanceBLService_Driver(SystemlogMaintenanceBLService SystemlogMaintenanceBLService) {
                this.systemlogMaintenanceBLService = SystemlogMaintenanceBLService;
        }
        
        public void drive() {
                System.out.println(systemlogMaintenanceBLService.addSystemlog(new SystemlogVO()).getKey());
                System.out.println(systemlogMaintenanceBLService.showSystemlog().getKey());
        }
}
