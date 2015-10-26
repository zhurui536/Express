package main.bussinesslogicservice.infoblservice._driver;

import main.bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import main.bussinesslogicservice.infoblservice._stub.InstitutionMessageMaintenanceBLService_Stub;
import main.vo.InstitutionMessageVO;

public class InstitutionMessageMaintenanceBLService_Driver {
private InstitutionMessageMaintenanceBLService institutionMessageMaintenanceBLService;
        
        public static void main(String[] args) {
                InstitutionMessageMaintenanceBLService institutionMessageMaintenanceBLService = new InstitutionMessageMaintenanceBLService_Stub();
                InstitutionMessageMaintenanceBLService_Driver driver = new InstitutionMessageMaintenanceBLService_Driver(institutionMessageMaintenanceBLService);
                driver.drive();
        }
        
        public InstitutionMessageMaintenanceBLService_Driver(InstitutionMessageMaintenanceBLService institutionMessageMaintenanceBLService) {
                this.institutionMessageMaintenanceBLService = institutionMessageMaintenanceBLService;
        }
        
        public void drive() {
                System.out.println(institutionMessageMaintenanceBLService.addInstitutionMessage(new InstitutionMessageVO()).getKey());
                System.out.println(institutionMessageMaintenanceBLService.delInstitutionMessage(000000000).getKey());
                System.out.println(institutionMessageMaintenanceBLService.modInstitutionMessage(new InstitutionMessageVO()).getKey());
                System.out.println(institutionMessageMaintenanceBLService.showInstitutionMessage(000000000).getKey());
                institutionMessageMaintenanceBLService.endInstitutionMessageMaintenance();
        }
}
