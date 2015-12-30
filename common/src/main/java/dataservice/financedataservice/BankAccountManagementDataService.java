package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.financepo.BankAccountPO;
import util.ResultMessage;

/**
 * 银行账户管理数据层
 * Created by Away
 * 2015/10/26
 */

public interface BankAccountManagementDataService extends Remote {
    /**
     * 根据 id 查找银行账户。
     * @param id 账户id
     * @return 成功返回 success 和 账户，失败返回 fail
     * @throws RemoteException
     */
    ResultMessage find(String id) throws RemoteException;

    /**
     * 查找所有银行账户
     * @return 成功返回 success 和 账户，失败返回 fail
     * @throws RemoteException
     */
    ResultMessage findAll() throws RemoteException;

    /**
     * 插入银行账户
     * @param po 账户 PO
     * @return 成功返回 success，失败返回 fail
     * @throws RemoteException
     */
    ResultMessage insert(BankAccountPO po) throws RemoteException;

    /**
     * 根据 id 删除银行账户
     * @param id 账户 id
     * @return 成功返回 success，失败返回 fail
     * @throws RemoteException
     */
    ResultMessage delete(String id) throws RemoteException;

    /**
     * 更新银行账户信息
     * @param po 新的账户PO
     * @return 成功返回 success，失败返回 fail
     * @throws RemoteException
     */
    ResultMessage update(BankAccountPO po) throws RemoteException;
}
