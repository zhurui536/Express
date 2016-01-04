package presentation.financeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.BankAccountPanel;
import presentation.financeui.tool.BankAccountManagementTool;
import presentation.financeui.tool.CheckTool;
import presentation.financeui.tool.InitTool;
import presentation.financeui.tool.PayTool;
import presentation.financeui.tool.ReceiptTool;
import presentation.financeui.tool.ReportTool;
import presentation.mainui.component.MenuButton;
import presentation.mainui.component.MyTool;
import presentation.userui.data.LogDataPane;
import util.ResultMessage;
import vo.SystemlogVO;
import vo.financevo.BankAccountVO;

/**
 * Created by Away
 * 2015/12/8
 */

public class MenuListener implements ActionListener {

    private FinanceFrame ui;

    private MyTool bankAcManageTool;

    private MyTool payTool;

    private MyTool receiptTool;

    private MyTool reportTool;

    private MyTool initTool;

    private LogDataPane logDataPane;
    
    private MyTool checkTool;
    
    public MenuListener(FinanceFrame ui) {
        this.ui = ui;
        bankAcManageTool = new BankAccountManagementTool(ui);
        payTool = new PayTool(ui);
        receiptTool = new ReceiptTool(ui);
        reportTool = new ReportTool(ui);
        initTool = new InitTool(ui);
        checkTool = new CheckTool(ui);
    }

//    private final String[] names = {"账户管理", "付款", "收款", "报表查看", "期初建账", "日志查看", "审批查看"};
    
    @SuppressWarnings("unchecked")
    @Override
    public void actionPerformed(ActionEvent e) {
        MenuButton button = (MenuButton) e.getSource();
        ui.refreshMenu();
        button.clicked();
        ui.paintdata(null);

        if (button == ui.getButton(0)) {
            ui.replaceTool(bankAcManageTool);
            FinanceBLService financeController = ui.getFinanceController();
            ResultMessage msg = financeController.showAllMember();
            if (!isFail(msg)) {
            	List<BankAccountVO> bankAccountVOs = (List<BankAccountVO>) msg.getValue();
                BankAccountPanel bankAccountPanel = new BankAccountPanel(bankAccountVOs);
                ui.paintdata(bankAccountPanel);
            }
        } else if (button == ui.getButton(1)) {
            ui.replaceTool(payTool);
        } else if (button == ui.getButton(2)) {
            ui.replaceTool(receiptTool);
        } else if (button == ui.getButton(3)) {
            ui.replaceTool(reportTool);
        } else if (button == ui.getButton(4)) {
            ui.replaceTool(initTool);
        } else if (button == ui.getButton(5)) {
            ui.replaceTool(null);
            FinanceBLService financeController = ui.getFinanceController();
            ResultMessage msg = financeController.showLog();
            if (isFail(msg)) {
                new WarningDialog(ui, "查看日志失败");
            } else {
                ArrayList<SystemlogVO> systemlogVOs = (ArrayList<SystemlogVO>) msg.getValue();
                logDataPane = new LogDataPane(systemlogVOs);
                ui.paintdata(logDataPane);
            }
        } else if (button == ui.getButton(6)) {
        	ui.replaceTool(checkTool);
        }
    }

    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("FAIL");
    }
}
