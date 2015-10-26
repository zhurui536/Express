package main.dataservice.logisticsdataservice._stub;

import main.dataservice.logisticsdataservice.BillQueryDataService;
import main.po.BillPO;

/**
 * @author zhuding
 *
 */
public class BillQueryDataService_Stub implements BillQueryDataService {

        @Override
        public BillPO find(long id) {
               
                return new BillPO();
        }

}
