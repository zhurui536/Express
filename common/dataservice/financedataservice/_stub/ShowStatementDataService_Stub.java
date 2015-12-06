package dataservice.financedataservice._stub;

import dataservice.financedataservice.ShowStatementDataService;
import main.bussinesslogic.util.ResultMessage;

import java.rmi.RemoteException;

/**
 * 查看经营情况表数据层的桩
 * Created by Away
 * 2015/10/26
 */

public class ShowStatementDataService_Stub implements ShowStatementDataService {

    @Override
    public ResultMessage findAllPayBill() throws RemoteException {
        return null;
    }
}
