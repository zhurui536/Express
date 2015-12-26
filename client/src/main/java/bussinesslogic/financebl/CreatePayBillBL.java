package bussinesslogic.financebl;

import java.util.List;
import java.rmi.RemoteException;

import bussinesslogicservice.financeblservice.CreatePayBillBLService;
import connection.ClientRMIHelper;
import dataservice.financedataservice.BankAccountManagementDataService;
import dataservice.financedataservice.CreatePayBillDataService;
import po.financepo.BankAccountPO;
import po.financepo.PayBillPO;
import util.ResultMessage;
import vo.financevo.PayBillVO;

/**
 * 付款单
 * Created by Away
 * 2015/11/15
 */

public class CreatePayBillBL implements CreatePayBillBLService {

    private CreatePayBillDataService createPayBillDataServiceImpl;
    
    private BankAccountManagementDataService bankAccountManagementDataServiceImpl;
    
    public CreatePayBillBL() {
        createPayBillDataServiceImpl = (CreatePayBillDataService) 
        		ClientRMIHelper.getServiceByName("CreatePayBillDataServiceImpl");
        bankAccountManagementDataServiceImpl = (BankAccountManagementDataService) 
        		ClientRMIHelper.getServiceByName("BankAccountManagementDataServiceImpl");
    }

    @Override
    public ResultMessage createPayBill(PayBillVO payBillVO) {
    	boolean valid = checkAccount(payBillVO.bankAccountID);
        PayBillPO payBillPO = new PayBillPO(payBillVO);
        try {
            return createPayBillDataServiceImpl.insert(payBillPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

	private boolean checkAccount(String id) {
		try {
			ResultMessage msg = bankAccountManagementDataServiceImpl.findAll();
			if (!isValidMsg(msg)) {
				return false;
			}
			@SuppressWarnings("unchecked")
			List<BankAccountPO> bankAccountPOs = (List<BankAccountPO>) msg.getValue();
			for (BankAccountPO po : bankAccountPOs) {
				if (po.getId().equals(id)) {
					
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean isValidMsg(ResultMessage message) {
		return message.getKey().equals("success");
	}
}
