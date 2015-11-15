package main.dataservice.financedataservice._stub;

import main.bussinesslogic.util.BillType;
import main.dataservice.financedataservice.ShowReceiptDataService;
import main.po.BillPO;

import java.rmi.RemoteException;

/**
 * 查看收款单
 * Created by Away
 * 2015/10/26
 */

public class ShowReceiptDataService_Stub implements ShowReceiptDataService {

    @Override
    public BillPO find(long time, long id) throws RemoteException {
        System.out.println("receipt find success");
        return new BillPO("123456789", BillType.DELIVERY, "away");
    }
}
