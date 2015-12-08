package dataservice.financedataservice;

import main.bussinesslogic.util.ResultMessage;
import po.financepo.AccountPO;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 期初建账数据层
 * Created by Away
 * 2015/10/26
 */

public interface CreateAccountingDataService extends Remote {

    /**
     * 期初账本信息存储
     * @param po 账本
     * @throws RemoteException
     */
    ResultMessage initInsert(AccountPO po) throws RemoteException;

    /**
     * 查询所有期初信息
     * @return ResultMessage
     * @throws RemoteException
     */
    ResultMessage findAllInitInfo() throws RemoteException;
}
