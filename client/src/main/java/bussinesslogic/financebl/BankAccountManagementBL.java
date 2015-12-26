package bussinesslogic.financebl;

import bussinesslogicservice.financeblservice.BankAccountManagementBLService;
import connection.ClientRMIHelper;
import dataservice.financedataservice.BankAccountManagementDataService;
import po.financepo.BankAccountPO;
import util.ResultMessage;
import vo.financevo.BankAccountVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * 银行账户管理
 * Created by Away
 * 2015/11/15
 */

public class BankAccountManagementBL implements BankAccountManagementBLService {

    BankAccountManagementDataService bankAccountManagementDataServiceImpl;

    public BankAccountManagementBL() {
        bankAccountManagementDataServiceImpl = (BankAccountManagementDataService) ClientRMIHelper.getServiceByName("BankAccountManagementDataServiceImpl");
    }

    @Override
    public ResultMessage createMember(BankAccountVO vo) {
        try {
            BankAccountPO bankAccountPO = new BankAccountPO(vo.name, vo.balance, vo.id);
            return bankAccountManagementDataServiceImpl.insert(bankAccountPO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage deleteMember(String id) {
        try {
            return bankAccountManagementDataServiceImpl.delete(id);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @Override
    public ResultMessage updateMember(BankAccountVO vo) {
        try {
        	ResultMessage message = bankAccountManagementDataServiceImpl.find(vo.id);
        	if (message.getKey().equals("fail")) {
        		return message;
        	}
        	BankAccountPO po = (BankAccountPO) message.getValue();
        	po.setName(vo.name);
            return bankAccountManagementDataServiceImpl.update(po);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public ResultMessage inquireMember(BankAccountVO vo) {
        try {
            // 根据 id 查找
            if (vo.id != null) {
                ResultMessage message = bankAccountManagementDataServiceImpl.find(vo.id);
                if (message.getKey().equals("fail")) {
                    return message;
                }
                BankAccountPO bankAccountPO = (BankAccountPO) message.getValue();
                List<BankAccountVO> bankAccountVOs = new ArrayList<>();
                bankAccountVOs.add(bankAccountPO.poToVo());
                return new ResultMessage("success", bankAccountVOs);
            }

            // 根据名字模糊匹配
            ResultMessage message = bankAccountManagementDataServiceImpl.findAll();
            if (message.getKey().equals("fail")) {
                return message;
            }

            ArrayList<BankAccountPO> bankAccountPOs = (ArrayList<BankAccountPO>) message.getValue();
            ArrayList<BankAccountVO> bankAccountVOs = matchName(bankAccountPOs, vo.name);
            if (bankAccountVOs.size() == 0) {
                return new ResultMessage("fail");
            }

            return new ResultMessage("success", bankAccountVOs);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }

    // TODO 模糊匹配
    private ArrayList<BankAccountVO> matchName(ArrayList<BankAccountPO> bankAccountPOs, String name) {
        ArrayList<BankAccountVO> bankAccountVOs = new ArrayList<>();
        for (BankAccountPO bankAccountPO : bankAccountPOs) {
            if (bankAccountPO.getName().contains(name)) {
                bankAccountVOs.add(bankAccountPO.poToVo());
            }
        }
        return bankAccountVOs;
    }
}
