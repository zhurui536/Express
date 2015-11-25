package dataservice.financedataservice;

import po.BillPO;

import java.rmi.RemoteException;

/**
 * 创建付款单数据层
 * Created by Away
 * 2015/10/26
 */

public interface CreatePayListDataService {

    // TODO 单据
    void insert(BillPO po) throws RemoteException;
}
