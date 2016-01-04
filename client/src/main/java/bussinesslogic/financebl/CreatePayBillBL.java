package bussinesslogic.financebl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;

import bussinesslogicservice.financeblservice.CreatePayBillBLService;
import connection.ClientRMIHelper;
import dataservice.financedataservice.BankAccountManagementDataService;
import dataservice.financedataservice.CreatePayBillDataService;
import po.financepo.BankAccountPO;
import po.financepo.PayBillPO;
import util.BillState;
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
    	ResultMessage msg = processAccount(payBillVO.bankAccountID, payBillVO.getMoney());
    	if (!isValidMsg(msg)) {
    		return msg;
    	}
        PayBillPO payBillPO = new PayBillPO(payBillVO);
        try {
        	payBillPO.setState(BillState.SUBMTTED);
            ResultMessage resultMessage = createPayBillDataServiceImpl.insert(payBillPO);
            resultMessage.setValue(payBillPO.getId());
            return resultMessage;
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

	private ResultMessage processAccount(String id, BigDecimal money) {
		try {
			ResultMessage msg = bankAccountManagementDataServiceImpl.findAll();
			if (!isValidMsg(msg)) {
				return new ResultMessage("id not found");
			}
			@SuppressWarnings("unchecked")
			List<BankAccountPO> bankAccountPOs = (List<BankAccountPO>) msg.getValue();
			for (BankAccountPO po : bankAccountPOs) {
				if (po.getId().equals(id)) {
					return subtract(po, money);
				}
			}
			return new ResultMessage("id not found");
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("fail");
		}
	}
	
	private ResultMessage subtract(BankAccountPO po, BigDecimal money) {
		money = po.getBalance().subtract(money);
		if (money.compareTo(BigDecimal.ZERO) < 0) {
			return new ResultMessage("money not enough");
		}
		po.setBalance(money);
		try {
			return bankAccountManagementDataServiceImpl.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("fail");
		}
	}

	private boolean isValidMsg(ResultMessage message) {
		return message.getKey().equals("success");
	}
}
