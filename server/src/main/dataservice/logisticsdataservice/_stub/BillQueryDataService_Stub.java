package main.dataservice.logisticsdataservice._stub;

import main.bussinesslogic.util.BillType;
import main.dataservice.logisticsdataservice.BillQueryDataService;
import main.po.BillPO;

/**
 * @author zhuding
 *
 */
public class BillQueryDataService_Stub implements BillQueryDataService {

        @Override
        public BillPO find(String id) {
               
                return new BillPO("0000000000",BillType.SEND);
        }

}
