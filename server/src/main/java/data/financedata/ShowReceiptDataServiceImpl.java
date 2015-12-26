package data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.Database;
import dataservice.financedataservice.ShowReceiptDataService;
import po.logisticpo.ReceiptBillPO;
import util.ResultMessage;

/**
 * Created by Away
 * 2015/12/7
 */

public class ShowReceiptDataServiceImpl extends UnicastRemoteObject implements ShowReceiptDataService {

    private static final long serialVersionUID = -715121312177936353L;

    private static final String PATH = "src/main/java/save/logisticsdata/receiptBillPO.dat";

    public ShowReceiptDataServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage findAll() throws RemoteException {
        List<ReceiptBillPO> receiptBillPOs = (List<ReceiptBillPO>) Database.load(PATH);
        if (receiptBillPOs == null) {
            receiptBillPOs = new ArrayList<>();
        }
        return new ResultMessage("success", receiptBillPOs);
    }
}
