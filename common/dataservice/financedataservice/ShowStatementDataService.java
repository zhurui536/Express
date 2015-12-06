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
     * 返回所有收款单
     * @return ResultMessage
     */
    ResultMessage findAllReceiptBill() throws RemoteException;

    /**
     * TODO
     * 返回所有付款单
     * @return ResultMessage
     * @throws RemoteException
     */
    ResultMessage findAllPayBill() throws RemoteException;
}
