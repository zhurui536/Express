package main.dataservice.logisticsdataservice._stub;

import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;
import main.dataservice.logisticsdataservice.DeliveryDataService;
import main.po.GoodsPO;

/**
 * @author zhuding
 *
 */
public class DeliveryDataService_Stub implements DeliveryDataService{

        private GoodsPO goodsPO;
        
        public DeliveryDataService_Stub() {
                goodsPO = new GoodsPO(0000000000,"核弹", "南京","北京" ,3, 40, PackageType.COURIER_BAG, ExpressType.EXPRESS);
        }
        
        @Override
        public GoodsPO findGoods(long id) {
                return goodsPO;
        }

        @Override
        public void updateGoods(GoodsPO goodsPO) {
                this.goodsPO = goodsPO;
                System.out.println(this.goodsPO.getRecipient());
                System.out.println(this.goodsPO.getTime());
        }

}
