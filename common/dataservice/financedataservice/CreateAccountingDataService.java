package dataservice.financedataservice;

import main.bussinesslogic.util.ResultMessage;
import po.financepo.AccountPO;

import java.rmi.RemoteException;

/**
 * 期初建账数据层
 * Created by Away
 * 2015/10/26
 */

public interface CreateAccountingDataService {

    /**
     * 期初账本信息存储
     * @param po 账本
     * @throws RemoteException
     */
    ResultMessage initInsert(AccountPO po) throws RemoteException;


}
