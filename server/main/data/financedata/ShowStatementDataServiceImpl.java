package main.data.financedata;

import dataservice.financedataservice.ShowStatementDataService;
import main.bussinesslogic.util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 显示经营情况表数据层实现
 * Created by Away
 * 2015/12/6
 */

public class ShowStatementDataServiceImpl extends UnicastRemoteObject implements ShowStatementDataService {

    private static final long serialVersionUID = 2841175035701519270L;

    public ShowStatementDataServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage findAllReceiptBill() throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage findAllPayBill() throws RemoteException {
        return null;
    }
}
