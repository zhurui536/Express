package main.bussinesslogicservice.infoblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.infoblservice.StaffMessageMaintenanceBLService;
import main.vo.StaffMessageVO;

/**
 * @author zhuding
 *
 */
public class StaffMessageMaintenanceBLService_Stub implements StaffMessageMaintenanceBLService{

        @Override
        public ResultMessage addStaffMessage(StaffMessageVO staffMessage) {
                // TODO Auto-generated method stub
                return new ResultMessage("add success!",null);
        }


        @Override
        public ResultMessage modStaffMessage(StaffMessageVO staffMessage) {
                // TODO Auto-generated method stub
                return new ResultMessage("mod success!",null);
        }



        @Override
        public ResultMessage delStaffMessage(String staffId) {
                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public ResultMessage showStaffMessage(String staffId) {
                // TODO Auto-generated method stub
                return null;
        }

}
