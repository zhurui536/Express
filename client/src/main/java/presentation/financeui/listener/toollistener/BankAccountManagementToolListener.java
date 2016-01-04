package presentation.financeui.listener.toollistener;

import java.awt.event.ActionEvent;
import java.util.List;

import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.BankAccountPanel;
import presentation.financeui.dialog.BankAccountAddDialog;
import presentation.financeui.dialog.BankAccountDelDialog;
import presentation.financeui.dialog.BankAccountFindDialog;
import presentation.financeui.dialog.BankAccountUpdateDialog;
import presentation.financeui.listener.ToolListener;
import presentation.mainui.component.MyTool;
import util.ResultMessage;
import vo.financevo.BankAccountVO;

/**
 * Created by Away
 * 2015/12/8
 */

public class BankAccountManagementToolListener extends ToolListener {
	
    public BankAccountManagementToolListener(FinanceFrame ui) {
        super(ui);
    }

	@Override
    public void actionPerformed(ActionEvent e) {
		FinanceFrame ui = (FinanceFrame) this.ui;
        Object button = e.getSource();
        MyTool toolPanel = ui.getTool();
        
        if (button == toolPanel.getButton(0)) {
            BankAccountAddDialog dialog = new BankAccountAddDialog(ui);
            dialog.setVisible(true);
            showAll();
        } else if (button == toolPanel.getButton(1)) {
            BankAccountDelDialog dialog = new BankAccountDelDialog(ui);
            dialog.setVisible(true);
            String id = dialog.getID();
            if (id != null) {
                processDel(dialog.getID());
            }
        } else if (button == toolPanel.getButton(2)) {
            BankAccountFindDialog dialog = new BankAccountFindDialog(ui);
            dialog.setVisible(true);
            BankAccountVO bankAccountVO = dialog.getBankAccountVO();
            if (bankAccountVO != null) {
                processFind(bankAccountVO);
            }
        } else if (button == toolPanel.getButton(3)) {
            BankAccountUpdateDialog dialog = new BankAccountUpdateDialog(ui);
            dialog.setVisible(true);
            BankAccountVO bankAccountVO = dialog.getBankAccountVO();
            if (bankAccountVO != null) {
                processUpdate(bankAccountVO);
            }
        } 
    }
    
    @SuppressWarnings("unchecked")
	private void showAll() {
    	ResultMessage msg = financeController.showAllMember();
        if (!isFail(msg)) {
        	List<BankAccountVO> bankAccountVOs = (List<BankAccountVO>) msg.getValue();
            BankAccountPanel bankAccountPanel = new BankAccountPanel(bankAccountVOs);
            ui.paintdata(bankAccountPanel);
        }
	}

	private void processUpdate(BankAccountVO bankAccountVO) {
    	ResultMessage msg = financeController.updateMember(bankAccountVO);
        if (isFail(msg)) {
            new WarningDialog(ui, "未找到该用户");
        } else {
            showAll();
        }		
	}

	@SuppressWarnings("unchecked")
	private void processFind(BankAccountVO bankAccountVO) {
    	ResultMessage msg = financeController.inquireMember(bankAccountVO);
        if (isFail(msg)) {
            new WarningDialog(ui, "未找到该用户");
        } else {
        	List<BankAccountVO> bankAccountVOs = (List<BankAccountVO>) msg.getValue();
            BankAccountPanel bankAccountPanel = new BankAccountPanel(bankAccountVOs);
            ui.paintdata(bankAccountPanel);
        }
	}

	private void processDel(String id) {
    	ResultMessage msg = financeController.deleteMember(id);
        if (isFail(msg)) {
            new WarningDialog(ui, "未找到该用户");
        } else {
            showAll();
        }
	}

	private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }
}
