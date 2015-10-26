package main.bussinesslogicservice.logisticsblservice._stub;

import main.bussinesslogicservice.logisticsblservice.BillQueryBLService;
import main.dataservice.logisticsdataservice.BillQueryDataService;
import main.po.BillPO;
import main.vo.BillVO;

/**
 * @author zhuding
 *
 */
public class BillQueryBLService_Stub implements BillQueryBLService{
        
        private BillQueryDataService billQueryDataService ;
        
        public BillQueryBLService_Stub(BillQueryDataService billQueryDataService) {
                this.billQueryDataService = billQueryDataService;
        }
        
        @Override
        public BillVO queryBill(long id) {
                BillPO billPO = billQueryDataService.find(id);
                //将PO对象转为VO对象
                return new BillVO();
        }

        @Override
        public void endQueryBill() {
                System.out.println("Success!");
        }


}
