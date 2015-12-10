package bussinesslogicservice.infoblservice;

import util.ResultMessage;
import vo.TruckMessageVO;

/**
 * @author zhuding
 *
 */
public interface TruckMessageMaintenanceBLService {
        public ResultMessage addTruckMessage(TruckMessageVO truckMessage);
        
        public ResultMessage delTruckMessage(String truckId);
        
        public ResultMessage modTruckMessage(TruckMessageVO truckMessage);
        
        public ResultMessage showTruckMessage(String truckId);
        

}
