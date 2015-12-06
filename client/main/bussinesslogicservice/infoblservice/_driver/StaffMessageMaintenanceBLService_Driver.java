package main.bussinesslogicservice.infoblservice._driver;

import main.bussinesslogicservice.infoblservice.StaffMessageMaintenanceBLService;
import main.bussinesslogicservice.infoblservice._stub.StaffMessageMaintenanceBLService_Stub;
import main.vo.StaffMessageVO;

public class StaffMessageMaintenanceBLService_Driver {
        
        private StaffMessageMaintenanceBLService staffMessageMaintenanceBLService;
        
        public static void main(String[] args) {
                StaffMessageMaintenanceBLService StaffMessageMaintenanceBLService = new StaffMessageMaintenanceBLService_Stub();
                StaffMessageMaintenanceBLService_Driver driver = new StaffMessageMaintenanceBLService_Driver(StaffMessageMaintenanceBLService);
                driver.drive();
        }
        
        public StaffMessageMaintenanceBLService_Driver(StaffMessageMaintenanceBLService StaffMessageMaintenanceBLService) {
                this.staffMessageMaintenanceBLService = StaffMessageMaintenanceBLService;
        }
        
        public void drive() {
                System.out.println(staffMessageMaintenanceBLService.addStaffMessage(new StaffMessageVO(null, null)).getKey());
                System.out.println(staffMessageMaintenanceBLService.delStaffMessage(000000000).getKey());
                System.out.println(staffMessageMaintenanceBLService.modStaffMessage(new StaffMessageVO(null, null)).getKey());
                System.out.println(staffMessageMaintenanceBLService.showStaffMessage(000000000).getKey());
                staffMessageMaintenanceBLService.endStaffMessageMaintenance();
        }
}
