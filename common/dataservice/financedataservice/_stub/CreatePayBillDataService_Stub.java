package dataservice.financedataservice._stub;

import dataservice.financedataservice.CreatePayBillDataService;
import main.bussinesslogic.util.ResultMessage;
import po.financepo.PayBillPO;

import java.rmi.RemoteException;

/**
 * 新建付款单数据层的桩
 * Created by Away
 * 2015/10/26
 */

public class CreatePayBillDataService_Stub implements CreatePayBillDataService {

    @Override
    public ResultMessage insert(PayBillPO po) throws RemoteException {
        System.out.println("insert success");
        return null;
    }
}
