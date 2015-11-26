package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.GoodsPO;

/**
 * @author zhuding
 */
public interface DeliveryDataService {
        
        public GoodsPO findGoods(String id) throws RemoteException;
        
        public void updateGoods(GoodsPO goodsPO) throws RemoteException;

}
