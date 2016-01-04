package bussinesslogic.financebl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import bussinesslogicservice.financeblservice.ShowReceiptBLService;
import connection.ClientRMIHelper;
import dataservice.financedataservice.BankAccountManagementDataService;
import dataservice.financedataservice.ShowReceiptDataService;
import dataservice.logisticsdataservice.ReceiptBillProduceDataService;
import po.financepo.BankAccountPO;
import po.logisticpo.ReceiptBillPO;
import util.ResultMessage;
import util.Time;
import vo.logisticvo.ReceiptBillVO;

/**
 * 查看收款单实现
 * Created by Away
 * 2015/11/15
 */

public class ShowReceiptBL implements ShowReceiptBLService {

    private ShowReceiptDataService showReceiptDataServiceImpl;
    
    private BankAccountManagementDataService bankAccountManagementDataServiceImpl;
    
    private ReceiptBillProduceDataService receiptBillProduceDataServiceImpl;
    
    public ShowReceiptBL() {
        showReceiptDataServiceImpl = (ShowReceiptDataService) ClientRMIHelper.
                getServiceByName("ShowReceiptDataServiceImpl");
        bankAccountManagementDataServiceImpl = (BankAccountManagementDataService) ClientRMIHelper.
        		getServiceByName("BankAccountManagementDataServiceImpl");
        receiptBillProduceDataServiceImpl = (ReceiptBillProduceDataService) ClientRMIHelper.getServiceByName("ReceiptBillProduceDataServiceImpl");
    }

    @SuppressWarnings("unchecked")
	@Override
    public ResultMessage showReceipt(Time time, String id) {
        try {
            ResultMessage msg = showReceiptDataServiceImpl.findAll();
            if (msg.getKey().equals("fail")) {
                return msg;
            }

            List<ReceiptBillVO> receiptBillVOs = new ArrayList<>();
            List<ReceiptBillPO> receiptBillPOs = (List<ReceiptBillPO>) msg.getValue();
            for (ReceiptBillPO po : receiptBillPOs) {
                if (isValid(po, time, id)) {
                    receiptBillVOs.add(po.poToVo());
                }
            }
            return new ResultMessage("success", receiptBillVOs);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMessage("fail");
        }
    }
    
    
    
    /**
     * 检验是否符合搜索条件
     * @param po 带检查的收款单 po
     * @param time 搜索时间
     * @param id 营业厅 id
     * @return 符合为 true， 否则为 false
     */
    private boolean isValid(ReceiptBillPO po, Time time, String id) {
        return id.equals(po.getInstitutionID()) && time.equalsWithDay(po.getTime());
    }

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getUnSettledReceipt() {
		ResultMessage msg;
		try {
			msg = showReceiptDataServiceImpl.findAll();
			if (msg.getKey().equals("fail")) {
				return msg;
			}
			
			List<String> ids = new ArrayList<>();
			List<ReceiptBillPO> receiptBillPOs = (List<ReceiptBillPO>) msg.getValue();
			for (ReceiptBillPO po : receiptBillPOs) {
				// 若还未结算
				if (!po.isSettled()) {
					ids.add(po.getBillID());
				}
			}
			
			return new ResultMessage("success", ids);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("fail");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage settleReceipt(String billID, String accountID) {
		ResultMessage accountMsg;
		ResultMessage billMsg;
		BigDecimal money = null;
		try {
			// 得到所有收款单
			billMsg = showReceiptDataServiceImpl.findAll();
            if (billMsg.getKey().equals("fail")) {
                return billMsg;
            }
            List<ReceiptBillPO> receiptBillPOs = (List<ReceiptBillPO>) billMsg.getValue();
            // 找出对应 ID 的收款单
            for (ReceiptBillPO po : receiptBillPOs) {
				if (po.getBillID().equals(billID)) {
					money = po.getTotalMoney();
					po.setSettled(true);
					break;
				}
			}
            if (money == null) {
            	return new ResultMessage("no bill id");
            }
            
            updateBillPO(receiptBillPOs);
            
            // 得到所有银行账户
            accountMsg = bankAccountManagementDataServiceImpl.findAll();
			if (!isValidMsg(accountMsg)) {
				return new ResultMessage("id not found");
			}
			List<BankAccountPO> bankAccountPOs = (List<BankAccountPO>) accountMsg.getValue();
			// 银行账户结算
			for (BankAccountPO po : bankAccountPOs) {
				if (po.getId().equals(accountID)) {
					return add(po, money);
				}
			}
			return new ResultMessage("id not found");
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage("fail");
		}
	}
	
	// 更新收款单状态
	private void updateBillPO(List<ReceiptBillPO> receiptBillPOs) {
		try {
			receiptBillProduceDataServiceImpl.update(receiptBillPOs);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	// 增加银行账户余额
	private ResultMessage add(BankAccountPO po, BigDecimal money) {
		money = po.getBalance().add(money);
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









