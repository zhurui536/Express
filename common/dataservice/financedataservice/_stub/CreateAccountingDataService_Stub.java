package dataservice.financedataservice._stub;

import dataservice.financedataservice.CreateAccountingDataService;
import main.bussinesslogic.util.ResultMessage;
import po.financepo.AccountPO;

import java.rmi.RemoteException;

/**
 * 期初建账数据层的桩
 * Created by Away
 * 2015/10/26
 */

public class CreateAccountingDataService_Stub implements CreateAccountingDataService {

    @Override
    public ResultMessage initInsert(AccountPO po) throws RemoteException {
        System.out.println("initInsert success");
        return null;
    }

    @Override
    public ResultMessage findAllInitInfo() throws RemoteException {
        return null;
    }
}
