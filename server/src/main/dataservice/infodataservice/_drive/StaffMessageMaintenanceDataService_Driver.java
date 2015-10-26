package main.dataservice.infodataservice._drive;

import java.rmi.RemoteException;

import main.dataservice.infodataservice.DriverMessageMaintenanceDataService;
import main.dataservice.infodataservice.StaffMessageMaintenanceDataService;
import main.dataservice.infodataservice._stub.DriverMessageMaintenanceDataService_Stub;
import main.po.StaffMessagePO;

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
                        staffMessageMaintenanceDataService.insert(new StaffMessagePO());
                        staffMessageMaintenanceDataService.delete(00000);
                        staffMessageMaintenanceDataService.update(new StaffMessagePO());
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
