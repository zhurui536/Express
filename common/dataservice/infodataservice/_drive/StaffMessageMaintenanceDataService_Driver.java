package dataservice.infodataservice._drive;

import java.rmi.RemoteException;

import dataservice.infodataservice.DriverMessageMaintenanceDataService;
import dataservice.infodataservice.StaffMessageMaintenanceDataService;
import dataservice.infodataservice._stub.DriverMessageMaintenanceDataService_Stub;
import po.StaffMessagePO;

/**
 * @author zhuding
 *
 */
public class StaffMessageMaintenanceDataService_Driver {
        private StaffMessageMaintenanceDataService staffMessageMaintenanceDataService;
        
        public StaffMessageMaintenanceDataService_Driver(StaffMessageMaintenanceDataService StaffMessageMaintenanceDataService) {
                this.staffMessageMaintenanceDataService = StaffMessageMaintenanceDataService;
        }
        
        public void drive() {
                try {
                        staffMessageMaintenanceDataService.find(00000);
                        staffMessageMaintenanceDataService.insert(new StaffMessagePO(null,null));
                        staffMessageMaintenanceDataService.delete(00000);
                        staffMessageMaintenanceDataService.update(new StaffMessagePO(null,null));
                } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
        }
        
        public static void main(String[] args) {
                DriverMessageMaintenanceDataService driverMessageMaintenanceDataService = new DriverMessageMaintenanceDataService_Stub();
                DriverMessageMaintenanceDataService_Driver dataService_Driver = new DriverMessageMaintenanceDataService_Driver(driverMessageMaintenanceDataService);
                dataService_Driver.drive();
        }
        
}
