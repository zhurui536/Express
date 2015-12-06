package dataservice.financedataservice;

import main.bussinesslogic.util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 查看经营情况表数据层
 * Created by Away
 * 2015/10/26
 */

public interface ShowStatementDataService extends Remote {

    /**
     * TODO
     * 返回所有付款单
     * @return ResultMessage 成功返回 SUCCESS 和 付款单，失败返回 FAIL。
     * @throws RemoteException
     */
    ResultMessage findAllPayBill() throws RemoteException;
}
