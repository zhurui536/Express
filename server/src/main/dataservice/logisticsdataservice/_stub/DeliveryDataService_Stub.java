package main.dataservice.logisticsdataservice._stub;

import main.dataservice.logisticsdataservice.DeliveryDataService;
import main.po.GoodsPO;

/**
 * @author zhuding
 *
 */
public class DeliveryDataService_Stub implements DeliveryDataService{

        private GoodsPO goodsPO;
        
        public DeliveryDataService_Stub() {
                goodsPO = new GoodsPO();
        }
        
        @Override
        public GoodsPO findGoods(long id) {
                return goodsPO;
        }

        @Override
        public void updateGoods(GoodsPO goodsPO) {
                this.goodsPO = goodsPO;
        }

}
