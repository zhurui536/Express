package dataservice.financedataservice._stub;

import dataservice.financedataservice.CreatePayListDataService;
import po.BillPO;

import java.rmi.RemoteException;

/**
 * 新建付款单数据层的桩
 * Created by Away
 * 2015/10/26
 */

public class CreatePayListDataService_Stub implements CreatePayListDataService {

    @Override
    public void insert(BillPO po) throws RemoteException {
        System.out.println("insert success");
    }
}
