package dataservice.financedataservice._stub;

import dataservice.financedataservice.ShowReceiptDataService;
import main.bussinesslogic.util.ResultMessage;

import java.rmi.RemoteException;

/**
 * 查看收款单
 * Created by Away
 * 2015/10/26
 */

public class ShowReceiptDataService_Stub implements ShowReceiptDataService {

    @Override
    public ResultMessage findAll() throws RemoteException {
        System.out.println("receipt find success");
        return null;
    }
}
