package main.bussinesslogic.financebl;

import dataservice.financedataservice.CreateAccountingDataService;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.CreateAccountingBLService;
import main.connection.ClientRMIHelper;
import main.vo.financevo.AccountVO;
import po.financepo.AccountPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

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
            List<AccountPO> initAccountPOs = (List<AccountPO>) msg.getValue();
            for (AccountPO po : initAccountPOs) {
                initAccountVOs.add(po.poToVo());
            }
            return new ResultMessage("success", initAccountVOs);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    private boolean isValidMsg(ResultMessage msg) {
        return msg.getKey().equals("success");
    }
}
