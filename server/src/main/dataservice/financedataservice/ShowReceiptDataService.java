package main.dataservice.financedataservice;

import main.po.BillPO;

import java.rmi.RemoteException;

/**
 * 显示收款单数据层
 * Created by Away
 * 2015/10/26
 */

public interface ShowReceiptDataService {

    // TODO

    /**
     * 得到收款单
     * @param time 时间
     * @param id 营业厅编号
     * @return 收款单
     * @throws RemoteException
     */
    BillPO find(long time, long id) throws RemoteException;
}
