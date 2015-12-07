package main.bussinesslogicservice.infoblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.infoblservice.DriverMessageMaintenanceBLService;
import main.vo.DriverMessageVO;

public class DriverMessageMaintenanceBLService_Stub implements DriverMessageMaintenanceBLService{

        @Override
        public ResultMessage addDriverMessage(DriverMessageVO driverMessage) {
                //TODO
                return new ResultMessage("add success!",null);
        }

        @Override
        public ResultMessage delDriverMessage(String driverId) {
                
                return new ResultMessage("del success!",null);
        }

        @Override
        public ResultMessage modDriverMessage(DriverMessageVO driverMessage) {
                // TODO Auto-generated method stub
                return new ResultMessage("mod success!",null);
        }

        @Override
        public ResultMessage showDriverMessage(String driverId) {
                // TODO Auto-generated method stub
                return new ResultMessage("success!",null);
        }


}
