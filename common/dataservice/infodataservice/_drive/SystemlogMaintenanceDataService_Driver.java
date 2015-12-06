package dataservice.infodataservice._drive;

import java.rmi.RemoteException;

import dataservice.infodataservice._stub.SystemlogMaintenanceDataService_Stub;
import dataservice.infodataservice.SystemlogMaintenanceDataService;
import po.SystemlogPO;

/**
 * @author zhuding
 *
 */
public class SystemlogMaintenanceDataService_Driver {
        
        private SystemlogMaintenanceDataService systemlogMaintenanceDataService;
        
        public SystemlogMaintenanceDataService_Driver(SystemlogMaintenanceDataService systemlogMaintenanceDataService) {
                this.systemlogMaintenanceDataService = systemlogMaintenanceDataService;
        }
        
        public void drive() {
//                try {
//                        systemlogMaintenanceDataService.getSystemlog();
//                } catch (RemoteException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                }
//                try {
//                        systemlogMaintenanceDataService.insert(new SystemlogPO());
//                } catch (RemoteException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                }
        }
        
        public static void main(String[] args) {
                SystemlogMaintenanceDataService systemlogMaintenanceDataService = new SystemlogMaintenanceDataService_Stub();
                SystemlogMaintenanceDataService_Driver service_Driver = new SystemlogMaintenanceDataService_Driver(systemlogMaintenanceDataService);
                service_Driver.drive();
        }
}
