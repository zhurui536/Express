package dataservice.logisticsdataservice._stub;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.DeliveryDataService;
import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;
import po.GoodsPO;

/**
 * @author zhuding
 *
 */
public class DeliveryDataService_Stub implements DeliveryDataService {

        private GoodsPO goodsPO;
        
        public DeliveryDataService_Stub() {
//                goodsPO = new GoodsPO("0000000000","核弹", "南京","北京" ,3, 40, PackageType.COURIER_BAG, ExpressType.EXPRESS);
        }
        
        @Override
        public GoodsPO findGoods(String id) throws RemoteException {
                return goodsPO;
        }

        @Override
        public void updateGoods(GoodsPO goodsPO) throws RemoteException {
                this.goodsPO = goodsPO;
//                System.out.println(this.goodsPO.getRecipient());
//                System.out.println(this.goodsPO.getTime());
        }

}
