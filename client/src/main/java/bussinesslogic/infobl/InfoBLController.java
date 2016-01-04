package bussinesslogic.infobl;

import bussinesslogicservice.infoblservice.DriverMessageMaintenanceBLService;
import bussinesslogicservice.infoblservice.InfoBLSerivce;
import bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import bussinesslogicservice.infoblservice.StaffMessageMaintenanceBLService;
import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import bussinesslogicservice.infoblservice.TruckMessageMaintenanceBLService;
import util.LogFactory;
import util.ResultMessage;
import vo.DriverMessageVO;
import vo.InstitutionMessageVO;
import vo.StaffMessageVO;
import vo.SystemlogVO;
import vo.TruckMessageVO;

public class InfoBLController implements InfoBLSerivce {
        
        private DriverMessageMaintenanceBLService driverMessageMaintenanceBLService;
        
        private InstitutionMessageMaintenanceBLService institutionMessageMaintenanceBLService;
        
        private StaffMessageMaintenanceBLService staffMessageMaintenanceBLService;
        
        private TruckMessageMaintenanceBLService truckMessageMaintenanceBLService;
        
        private SystemlogMaintenanceBLService service;
        
        public InfoBLController() {
                driverMessageMaintenanceBLService  = (DriverMessageMaintenanceBLService) new DriverMessageMaintenanceBL();
                institutionMessageMaintenanceBLService = (InstitutionMessageMaintenanceBLService) new InstitutionMessageMaintenanceBL();
                staffMessageMaintenanceBLService = (StaffMessageMaintenanceBLService) new StaffMessageMaintenanceBL();
                truckMessageMaintenanceBLService = (TruckMessageMaintenanceBLService) new TruckMessageMaintenanceBL();
                service = LogFactory.getInstance();
        }

        @Override
        public ResultMessage addDriverMessage(DriverMessageVO driverMessage) {
                service.addSystemlog(new SystemlogVO("新增司机信息"));
                return driverMessageMaintenanceBLService.addDriverMessage(driverMessage);
        }

        @Override
        public ResultMessage delDriverMessage(String driverId) {
                service.addSystemlog(new SystemlogVO("删除司机信息"));
                return driverMessageMaintenanceBLService.delDriverMessage(driverId);
        }

        @Override
        public ResultMessage modDriverMessage(DriverMessageVO driverMessage) {
                service.addSystemlog(new SystemlogVO("修改司机信息"));
                return driverMessageMaintenanceBLService.modDriverMessage(driverMessage);
        }

        @Override
        public ResultMessage getDriverMessage(String driverId) {
                service.addSystemlog(new SystemlogVO("查看司机信息"));
                return driverMessageMaintenanceBLService.getDriverMessage(driverId);
        }

        @Override
        public ResultMessage addInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                service.addSystemlog(new SystemlogVO("新增机构信息"));
                return institutionMessageMaintenanceBLService.addInstitutionMessage(institutionMessage);
        }

        @Override
        public ResultMessage delInstitutionMessage(String institutionId) {
                service.addSystemlog(new SystemlogVO("删除机构信息"));
                return institutionMessageMaintenanceBLService.delInstitutionMessage(institutionId);
        }

        @Override
        public ResultMessage modInstitutionMessage(
                        InstitutionMessageVO institutionMessage) {
                service.addSystemlog(new SystemlogVO("修改机构信息"));
                return institutionMessageMaintenanceBLService.modInstitutionMessage(institutionMessage);
        }

        @Override
        public ResultMessage showInstitutionMessage(String institutionId) {
                service.addSystemlog(new SystemlogVO("查看机构信息"));
                return institutionMessageMaintenanceBLService.showInstitutionMessage(institutionId);
        }

        @Override
        public ResultMessage addStaffMessage(StaffMessageVO staffMessage) {
                service.addSystemlog(new SystemlogVO("新增人员信息"));
                return staffMessageMaintenanceBLService.addStaffMessage(staffMessage);
        }

        @Override
        public ResultMessage delStaffMessage(String staffId) {
                service.addSystemlog(new SystemlogVO("删除人员信息"));
                return staffMessageMaintenanceBLService.delStaffMessage(staffId);
        }

        @Override
        public ResultMessage modStaffMessage(StaffMessageVO staffMessage) {
                service.addSystemlog(new SystemlogVO("修改人员信息"));
                return staffMessageMaintenanceBLService.modStaffMessage(staffMessage);
        }

        @Override
        public ResultMessage showStaffMessage(String staffId) {
                service.addSystemlog(new SystemlogVO("查看人员信息"));
                return staffMessageMaintenanceBLService.showStaffMessage(staffId);
        }

        @Override
        public ResultMessage addTruckMessage(TruckMessageVO truckMessage) {
                service.addSystemlog(new SystemlogVO("新增车辆信息"));
                return truckMessageMaintenanceBLService.addTruckMessage(truckMessage);
        }

        @Override
        public ResultMessage delTruckMessage(String truckId) {
                service.addSystemlog(new SystemlogVO("删除车辆信息"));
                return truckMessageMaintenanceBLService.delTruckMessage(truckId);
        }

        @Override
        public ResultMessage modTruckMessage(TruckMessageVO truckMessage) {
                service.addSystemlog(new SystemlogVO("修改车辆信息"));
                return truckMessageMaintenanceBLService.modTruckMessage(truckMessage);
        }

        @Override
        public ResultMessage showTruckMessage(String truckId) {
                service.addSystemlog(new SystemlogVO("查看车辆信息"));
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

                @Override
                public ResultMessage showAllDriverMessage() {
                        return this.driverMessageMaintenanceBLService.showAllDriverMessage();
                }

}
