package dataservice.infodataservice._drive;

import java.rmi.RemoteException;

import dataservice.infodataservice.DriverMessageMaintenanceDataService;
import dataservice.infodataservice._stub.DriverMessageMaintenanceDataService_Stub;
import po.DriverMessagePO;

/**
 * @author zhuding
 *
 */
public class DriverMessageMaintenanceDataService_Driver {
        
        private DriverMessageMaintenanceDataService driverMessageMaintenanceDataService;
        
        public DriverMessageMaintenanceDataService_Driver(DriverMessageMaintenanceDataService driverMessageMaintenanceDataService) {
                this.driverMessageMaintenanceDataService = driverMessageMaintenanceDataService;
        }
        
        public void drive() {
                try {
                        driverMessageMaintenanceDataService.find(00000);
                        driverMessageMaintenanceDataService.insert(new DriverMessagePO());
                        driverMessageMaintenanceDataService.delete(00000);
                        driverMessageMaintenanceDataService.update(new DriverMessagePO());
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
