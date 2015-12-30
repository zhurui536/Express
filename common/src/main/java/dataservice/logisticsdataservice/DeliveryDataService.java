package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.GoodsPO;

/**
 * @author zhuding
 */
public interface DeliveryDataService extends Remote{
        
        public GoodsPO findGoods(String id) throws RemoteException;
        
        public void updateGoods(GoodsPO goodsPO) throws RemoteException;

}
