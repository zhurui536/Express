package dataservice.financedataservice;


import java.rmi.Remote;
import java.rmi.RemoteException;

import util.ResultMessage;

/**
 * 显示收款单数据层
 * Created by Away
 * 2015/10/26
 */

public interface ShowReceiptDataService extends Remote {

    // TODO

    /**
     * 得到所有收款单
     * @throws RemoteException
     */
    ResultMessage findAll() throws RemoteException;
}
