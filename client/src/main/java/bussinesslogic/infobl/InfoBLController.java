package bussinesslogic.infobl;

import bussinesslogicservice.infoblservice.*;
import util.ResultMessage;
import vo.DriverMessageVO;
import vo.InstitutionMessageVO;
import vo.StaffMessageVO;
import vo.TruckMessageVO;

public class InfoBLController implements InfoBLSerivce {
        
        private DriverMessageMaintenanceBLService driverMessageMaintenanceBLService;
        
        private InstitutionMessageMaintenanceBLService institutionMessageMaintenanceBLService;
        
        private StaffMessageMaintenanceBLService staffMessageMaintenanceBLService;
        
        private TruckMessageMaintenanceBLService truckMessageMaintenanceBLService;
        
        public InfoBLController() {
                driverMessageMaintenanceBLService  = (DriverMessageMaintenanceBLService) new DriverMessageMaintenanceBL();
                institutionMessageMaintenanceBLService = (InstitutionMessageMaintenanceBLService) new InstitutionMessageMaintenanceBL();
                staffMessageMaintenanceBLService = (StaffMessageMaintenanceBLService) new StaffMessageMaintenanceBL();
                truckMessageMaintenanceBLService = (TruckMessageMaintenanceBLService) new TruckMessageMaintenanceBL();
        }

        @Override
        public ResultMessage addDriverMessage(DriverMessageVO driverMessage) {
                return driverMessageMaintenanceBLService.addDriverMessage(driverMessage);
        }

        @Override
        public ResultMessage delDriverMessage(String driverId) {
                return driverMessageMaintenanceBLService.delDriverMessage(driverId);
        }

        @Override
        public ResultMessage modDriverMessage(DriverMessageVO driverMessage) {
                return driverMessageMaintenanceBLService.modDriverMessage(driverMessage);
        }

        @Override
        public ResultMessage showDriverMessage(String driverId) {
                return driverMessageMaintenanceBLService.showDriverMessage(driverId);
        }

        @Override
        public ResultMessage addInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                return institutionMessageMaintenanceBLService.addInstitutionMessage(institutionMessage);
        }

        @Override
        public ResultMessage delInstitutionMessage(String institutionId) {
                return institutionMessageMaintenanceBLService.delInstitutionMessage(institutionId);
        }

        @Override
        public ResultMessage modInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                return institutionMessageMaintenanceBLService.modInstitutionMessage(institutionMessage);
        }

        @Override
        public ResultMessage showInstitutionMessage(String institutionId) {
                return institutionMessageMaintenanceBLService.showInstitutionMessage(institutionId);
        }

        @Override
        public ResultMessage addStaffMessage(StaffMessageVO staffMessage) {
                return staffMessageMaintenanceBLService.addStaffMessage(staffMessage);
        }

        @Override
        public ResultMessage delStaffMessage(String staffId) {
                return staffMessageMaintenanceBLService.delStaffMessage(staffId);
        }

        @Override
        public ResultMessage modStaffMessage(StaffMessageVO staffMessage) {
                return staffMessageMaintenanceBLService.modStaffMessage(staffMessage);
        }

        @Override
        public ResultMessage showStaffMessage(String staffId) {
                return staffMessageMaintenanceBLService.showStaffMessage(staffId);
        }

        @Override
        public ResultMessage addTruckMessage(TruckMessageVO truckMessage) {
                return truckMessageMaintenanceBLService.addTruckMessage(truckMessage);
        }

        @Override
        public ResultMessage delTruckMessage(String truckId) {
                return truckMessageMaintenanceBLService.delTruckMessage(truckId);
        }

        @Override
        public ResultMessage modTruckMessage(TruckMessageVO truckMessage) {
                return truckMessageMaintenanceBLService.modTruckMessage(truckMessage);
        }

        @Override
        public ResultMessage showTruckMessage(String truckId) {
                return truckMessageMaintenanceBLService.showTruckMessage(truckId);
        }

		@Override
		public ResultMessage getStaff() {
			return this.staffMessageMaintenanceBLService.getStaff();
		}

		@Override
		public ResultMessage getInstitutionMessage() {
			return this.institutionMessageMaintenanceBLService.getInstitutionMessage();
		}

}
