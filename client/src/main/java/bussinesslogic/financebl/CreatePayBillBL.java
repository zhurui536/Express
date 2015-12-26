package bussinesslogic.financebl;

import bussinesslogicservice.financeblservice.CreatePayBillBLService;
import connection.ClientRMIHelper;
import dataservice.financedataservice.CreatePayBillDataService;
import po.financepo.PayBillPO;
import util.ResultMessage;
import vo.financevo.PayBillVO;

import java.rmi.RemoteException;

/**
 * 付款单
 * Created by Away
 * 2015/11/15
 */

public class CreatePayBillBL implements CreatePayBillBLService {

    private CreatePayBillDataService createPayBillDataServiceImpl;

    public CreatePayBillBL() {
        ClientRMIHelper clientRMIHelper = new ClientRMIHelper();
        createPayBillDataServiceImpl = (CreatePayBillDataService) clientRMIHelper.getServiceByName("CreatePayBillDataServiceImpl");
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
