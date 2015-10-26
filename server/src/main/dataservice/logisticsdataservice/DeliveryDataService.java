package main.dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import main.po.GoodsPO;

/**
 * @author zhuding
 *
 */
public interface DeliveryDataService {
        public GoodsPO findGoods(long id) throws RemoteException;
        
        public void updateGoods(GoodsPO goodsPO) throws RemoteException;

}
