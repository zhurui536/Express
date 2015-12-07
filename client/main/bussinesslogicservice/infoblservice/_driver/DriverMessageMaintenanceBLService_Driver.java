package main.bussinesslogicservice.infoblservice._driver;

import main.bussinesslogicservice.infoblservice.DriverMessageMaintenanceBLService;
import main.bussinesslogicservice.infoblservice._stub.DriverMessageMaintenanceBLService_Stub;
import main.vo.DriverMessageVO;

/**
 * @author zhuding
 *
 */
public class DriverMessageMaintenanceBLService_Driver {
        
        private DriverMessageMaintenanceBLService driverMessageMaintenanceBLService;
        
        public static void main(String[] args) {
                DriverMessageMaintenanceBLService driverMessageMaintenanceBLService = new DriverMessageMaintenanceBLService_Stub();
                DriverMessageMaintenanceBLService_Driver driver = new DriverMessageMaintenanceBLService_Driver(driverMessageMaintenanceBLService);
                driver.drive();
        }
        
        public DriverMessageMaintenanceBLService_Driver(DriverMessageMaintenanceBLService driverMessageMaintenanceBLService) {
                this.driverMessageMaintenanceBLService = driverMessageMaintenanceBLService;
        }
        
        public void drive() {
//                System.out.println(driverMessageMaintenanceBLService.addDriverMessage(new DriverMessageVO()).getKey());
//                System.out.println(driverMessageMaintenanceBLService.delDriverMessage("000000000").getKey());
//                System.out.println(driverMessageMaintenanceBLService.modDriverMessage(new DriverMessageVO()).getKey());
//                System.out.println(driverMessageMaintenanceBLService.showDriverMessage("000000000").getKey());
//                driverMessageMaintenanceBLService.endDriverMessageMaintenance();
        }
}
