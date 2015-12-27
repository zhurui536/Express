package presentation.financeui.listener;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.BankAccountPanel;
import presentation.financeui.tool.*;
import presentation.userui.data.LogDataPane;
import util.ResultMessage;
import vo.SystemlogVO;
import vo.financevo.BankAccountVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Away
 * 2015/12/8
 */

public class MenuListener implements ActionListener {

    private FinanceFrame ui;

    private ToolPanel bankAcManageTool;

    private ToolPanel payTool;

    private ToolPanel receiptTool;

    private ToolPanel reportTool;

    private ToolPanel initTool;

    private LogDataPane logDataPane;

    public MenuListener(FinanceFrame ui) {
        this.ui = ui;
        bankAcManageTool = new BankAccountManagementTool(ui);
        payTool = new PayTool(ui);
        receiptTool = new ReceiptTool(ui);
        reportTool = new ReportTool(ui);
        initTool = new InitTool(ui);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        ui.paintData(new JPanel());

        if (button == ui.getButton("账户管理")) {
            ui.replaceTool(bankAcManageTool);
            FinanceBLService financeController = ui.getFinanceController();
            ResultMessage msg = financeController.showAllMember();
            if (!isFail(msg)) {
            	List<BankAccountVO> bankAccountVOs = (List<BankAccountVO>) msg.getValue();
                BankAccountPanel bankAccountPanel = new BankAccountPanel(bankAccountVOs);
                ui.paintData(bankAccountPanel);
            }
        } else if (button == ui.getButton("付款")) {
            ui.replaceTool(payTool);
        } else if (button == ui.getButton("收款")) {
            ui.replaceTool(receiptTool);
        } else if (button == ui.getButton("报表查看")) {
            ui.replaceTool(reportTool);
        } else if (button == ui.getButton("期初建账")) {
            ui.replaceTool(initTool);
        } else if (button == ui.getButton("日志查看")) {
            ui.replaceTool(new ToolPanel());
            FinanceBLService financeController = ui.getFinanceController();
            ResultMessage msg = financeController.showLog();
            if (isFail(msg)) {
                new WarningDialog(ui, "查看日志失败");
            } else {
                ArrayList<SystemlogVO> systemlogVOs = (ArrayList<SystemlogVO>) msg.getValue();
                logDataPane = new LogDataPane(systemlogVOs);
                ui.paintData(logDataPane);
            }
        }
    }

    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("FAIL");
    }
}
