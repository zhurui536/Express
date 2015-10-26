package main.dataservice.financedataservice;

import main.po.AccountPO;

import java.rmi.RemoteException;

/**
 * 期初建账数据层
 * Created by Away
 * 2015/10/26
 */

public interface CreateAccountingDataService {

    /**
     * 期初账本信息存储
     * @param po
     * @throws RemoteException
     */
    void initInsert(AccountPO po) throws RemoteException;
}
