package main.dataservice.financedataservice._stub;

import main.dataservice.financedataservice.ShowStatementDataService;
import main.po.BillPO;
import main.po.StatementPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * 查看经营情况表数据层的桩
 * Created by Away
 * 2015/10/26
 */

public class ShowStatementDataService_Stub implements ShowStatementDataService {

    @Override
    public StatementPO find(long startTime, long endTime) throws RemoteException {
        System.out.println("statement find success");
        // TODO
        ArrayList<BillPO> receipt = new ArrayList<>();
        ArrayList<BillPO> payList = new ArrayList<>();
        return new StatementPO(receipt, payList);
    }
}
