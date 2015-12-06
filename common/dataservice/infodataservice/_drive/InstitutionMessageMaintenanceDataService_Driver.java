package dataservice.infodataservice._drive;

import java.rmi.RemoteException;

import dataservice.infodataservice.DriverMessageMaintenanceDataService;
import dataservice.infodataservice.InstitutionMessageMaintenanceDataService;
import dataservice.infodataservice._stub.DriverMessageMaintenanceDataService_Stub;
import po.InstitutionMessagePO;

/**
 * @author zhuding
 *
 */
public class InstitutionMessageMaintenanceDataService_Driver {
        private InstitutionMessageMaintenanceDataService institutionMessageMaintenanceDataService;
        
        public InstitutionMessageMaintenanceDataService_Driver(InstitutionMessageMaintenanceDataService institutionMessageMaintenanceDataService) {
                this.institutionMessageMaintenanceDataService = institutionMessageMaintenanceDataService;
        }
        
        public void drive() {
                try {
                        institutionMessageMaintenanceDataService.find(00000);
                        institutionMessageMaintenanceDataService.insert(new InstitutionMessagePO(null,null));
                        institutionMessageMaintenanceDataService.delete(00000);
                        institutionMessageMaintenanceDataService.update(new InstitutionMessagePO(null,null));
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