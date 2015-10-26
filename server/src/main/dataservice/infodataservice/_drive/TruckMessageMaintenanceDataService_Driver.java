package main.dataservice.infodataservice._drive;

import java.rmi.RemoteException;

import main.dataservice.infodataservice.DriverMessageMaintenanceDataService;
import main.dataservice.infodataservice.TruckMessageMaintenanceDataService;
import main.dataservice.infodataservice._stub.DriverMessageMaintenanceDataService_Stub;
import main.po.TruckMessagePO;

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
                        truckMessageMaintenanceDataService.insert(new TruckMessagePO());
                        truckMessageMaintenanceDataService.delete(00000);
                        truckMessageMaintenanceDataService.update(new TruckMessagePO());
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
