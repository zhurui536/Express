package dataservice.infodataservice._drive;

import java.rmi.RemoteException;

import dataservice.infodataservice.DriverMessageMaintenanceDataService;
import dataservice.infodataservice.TruckMessageMaintenanceDataService;
import dataservice.infodataservice._stub.DriverMessageMaintenanceDataService_Stub;
import po.TruckMessagePO;

/**
 * @author zhuding
 *
 */
public class TruckMessageMaintenanceDataService_Driver {
        private TruckMessageMaintenanceDataService truckMessageMaintenanceDataService;
        
        public TruckMessageMaintenanceDataService_Driver(TruckMessageMaintenanceDataService TruckMessageMaintenanceDataService) {
                this.truckMessageMaintenanceDataService = TruckMessageMaintenanceDataService;
        }
        
        public void drive() {
                try {
                        truckMessageMaintenanceDataService.find(00000);
                        truckMessageMaintenanceDataService.insert(new TruckMessagePO(null,null,10));
                        truckMessageMaintenanceDataService.delete(00000);
                        truckMessageMaintenanceDataService.update(new TruckMessagePO(null,null,10));
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
