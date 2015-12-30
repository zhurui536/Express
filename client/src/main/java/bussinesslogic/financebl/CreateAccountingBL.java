package bussinesslogic.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import bussinesslogicservice.financeblservice.CreateAccountingBLService;
import connection.ClientRMIHelper;
import dataservice.financedataservice.CreateAccountingDataService;
import po.financepo.AccountPO;
import util.ResultMessage;
import vo.financevo.AccountVO;

/**
 * 账本
 * Created by Away
 * 2015/11/15
 */

public class CreateAccountingBL implements CreateAccountingBLService {

    CreateAccountingDataService createAccountingDataImpl;

    public CreateAccountingBL() {
        createAccountingDataImpl = (CreateAccountingDataService) ClientRMIHelper.
                getServiceByName("CreateAccountingDataServiceImpl");
    }

    @Override
    public ResultMessage createAccounting(AccountVO accountVO) {
        AccountPO accountPO = new AccountPO(accountVO);
        try {
            return createAccountingDataImpl.initInsert(accountPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage inquireInitInfo() {
        try {
            ResultMessage msg = createAccountingDataImpl.findAllInitInfo();
            if (!isValidMsg(msg)) {
                return msg;
            }

            List<AccountVO> initAccountVOs = new ArrayList<>();
            @SuppressWarnings("unchecked")
			List<AccountPO> initAccountPOs = (List<AccountPO>) msg.getValue();
            for (AccountPO po : initAccountPOs) {
                initAccountVOs.add(po.poToVo());
            }
//            return new ResultMessage("success", initAccountVOs);
            if (initAccountVOs.size() == 0) {
                return new ResultMessage("success", null);
            }
            return new ResultMessage("success", initAccountVOs.get(initAccountVOs.size() - 1));
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    private boolean isValidMsg(ResultMessage msg) {
        return msg.getKey().equals("success");
    }
}
