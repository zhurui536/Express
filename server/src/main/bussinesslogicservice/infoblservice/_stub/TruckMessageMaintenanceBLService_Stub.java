package main.bussinesslogicservice.infoblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.infoblservice.TruckMessageMaintenanceBLService;
import main.vo.TruckMessageVO;

/**
 * @author zhuding
 *
 */
public class TruckMessageMaintenanceBLService_Stub implements TruckMessageMaintenanceBLService{

        @Override
        public ResultMessage addTruckMessage(TruckMessageVO truckMessage) {
                // TODO Auto-generated method stub
                return new ResultMessage("add success!",null);
        }

        @Override
        public ResultMessage delTruckMessage(long truckId) {
                // TODO Auto-generated method stub
                return new ResultMessage("del success!",null);
        }

        @Override
        public ResultMessage modTruckMessage(TruckMessageVO truckMessage) {
                // TODO Auto-generated method stub
                return new ResultMessage("mod success!",null);
        }

        @Override
        public ResultMessage showTruckMessage(long truckId) {
                // TODO Auto-generated method stub
                return new ResultMessage("success!",null);
        }

        @Override
        public void endTruckMessageMaintenance() {
                // TODO Auto-generated method stub
                System.out.println("SUCCESS!");
        }

}
