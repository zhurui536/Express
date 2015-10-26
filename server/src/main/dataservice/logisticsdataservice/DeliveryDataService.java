package main.dataservice.logisticsdataservice;

import main.po.GoodsPO;

/**
 * @author zhuding
 *
 */
public interface DeliveryDataService {
        public GoodsPO findGoods(long id);
        
        public void updateGoods(GoodsPO goodsPO);

}
