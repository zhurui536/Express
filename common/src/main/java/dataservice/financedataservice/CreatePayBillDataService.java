package dataservice.financedataservice;

import po.financepo.PayBillPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 创建付款单数据层
 * Created by Away
 * 2015/10/26
 */

public interface CreatePayBillDataService extends Remote {

    // TODO 单据
    ResultMessage insert(PayBillPO po) throws RemoteException;
}
