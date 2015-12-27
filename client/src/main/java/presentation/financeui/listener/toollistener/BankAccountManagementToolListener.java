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
import presentation.financeui.tool.ToolPanel;
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
        Object button = e.getSource();
        ToolPanel toolPanel = ui.getToolPanel();
        if (button == toolPanel.getButton("add")) {
            BankAccountAddDialog dialog = new BankAccountAddDialog(ui);
            dialog.setVisible(true);
            showAll();
        } else if (button == toolPanel.getButton("del")) {
            BankAccountDelDialog dialog = new BankAccountDelDialog(ui);
            dialog.setVisible(true);
            String id = dialog.getID();
            if (id != null) {
                processDel(dialog.getID());
            }
        } else if (button == toolPanel.getButton("find")) {
            BankAccountFindDialog dialog = new BankAccountFindDialog(ui);
            dialog.setVisible(true);
            BankAccountVO bankAccountVO = dialog.getBankAccountVO();
            if (bankAccountVO != null) {
                processFind(bankAccountVO);
            }
        } else if (button == toolPanel.getButton("update")) {
            BankAccountUpdateDialog dialog = new BankAccountUpdateDialog(ui);
            dialog.setVisible(true);
            BankAccountVO bankAccountVO = dialog.getBankAccountVO();
            if (bankAccountVO != null) {
                processUpdate(bankAccountVO);
            }
        } else if (button == toolPanel.getButton("back")) {
        	ui.replaceTool(new ToolPanel());
        	ui.paintData(null);
        }
    }
    
    @SuppressWarnings("unchecked")
	private void showAll() {
    	ResultMessage msg = financeController.showAllMember();
        if (!isFail(msg)) {
        	List<BankAccountVO> bankAccountVOs = (List<BankAccountVO>) msg.getValue();
            BankAccountPanel bankAccountPanel = new BankAccountPanel(bankAccountVOs);
            ui.paintData(bankAccountPanel);
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
            ui.paintData(bankAccountPanel);
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
