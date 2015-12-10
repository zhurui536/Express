package dataservice.logisticsdataservice;

import po.GoodsPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author zhuding
 */
public interface DeliveryDataService extends Remote{
        
        public GoodsPO findGoods(String id) throws RemoteException;
        
        public void updateGoods(GoodsPO goodsPO) throws RemoteException;

}
