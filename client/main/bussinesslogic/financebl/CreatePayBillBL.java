package main.bussinesslogic.financebl;

import dataservice.financedataservice.CreatePayBillDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreatePayBillBLService;
import main.connection.ClientRMIHelper;
import main.vo.PayBillVO;
import po.financepo.PayBillPO;

import java.rmi.RemoteException;

/**
 * 付款单
 * Created by Away
 * 2015/11/15
 */

public class CreatePayBillBL implements CreatePayBillBLService {

    private CreatePayBillDataService createPayBillDataServiceImpl;

    public CreatePayBillBL() {
        createPayBillDataServiceImpl = (CreatePayBillDataService) ClientRMIHelper.getServiceByName("CreatePayBillDataServiceImpl");
    }

    @Override
    public ResultMessage createPayBill(PayBillVO payBillVO) {
        PayBillPO payBillPO = new PayBillPO(payBillVO);
        try {
            return createPayBillDataServiceImpl.insert(payBillPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }
}
