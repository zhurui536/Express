package main.bussinesslogicservice.infoblservice._driver;

import main.bussinesslogicservice.infoblservice.TruckMessageMaintenanceBLService;
import main.bussinesslogicservice.infoblservice._stub.TruckMessageMaintenanceBLService_Stub;
import main.vo.TruckMessageVO;

/**
 * @author zhuding
 *
 */
public class TruckMessageMaintenanceBLService_Driver {
private TruckMessageMaintenanceBLService truckMessageMaintenanceBLService;
        
        public static void main(String[] args) {
                TruckMessageMaintenanceBLService TruckMessageMaintenanceBLService = new TruckMessageMaintenanceBLService_Stub();
                TruckMessageMaintenanceBLService_Driver driver = new TruckMessageMaintenanceBLService_Driver(TruckMessageMaintenanceBLService);
                driver.drive();
        }
        
        public TruckMessageMaintenanceBLService_Driver(TruckMessageMaintenanceBLService TruckMessageMaintenanceBLService) {
                this.truckMessageMaintenanceBLService = TruckMessageMaintenanceBLService;
        }
        
        public void drive() {
//                System.out.println(truckMessageMaintenanceBLService.addTruckMessage(new TruckMessageVO()).getKey());
//                System.out.println(truckMessageMaintenanceBLService.delTruckMessage(000000000).getKey());
//                System.out.println(truckMessageMaintenanceBLService.modTruckMessage(new TruckMessageVO()).getKey());
//                System.out.println(truckMessageMaintenanceBLService.showTruckMessage(000000000).getKey());
//                truckMessageMaintenanceBLService.endTruckMessageMaintenance();
        }
}
