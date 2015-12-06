package dataservice.financedataservice._stub;

import dataservice.financedataservice.CreateAccountingDataService;
import po.financepo.AccountPO;

import java.rmi.RemoteException;

/**
 * 期初建账数据层的桩
 * Created by Away
 * 2015/10/26
 */

public class CreateAccountingDataService_Stub implements CreateAccountingDataService {

    @Override
    public void initInsert(AccountPO po) throws RemoteException {
        System.out.println("initInsert success");
    }
}