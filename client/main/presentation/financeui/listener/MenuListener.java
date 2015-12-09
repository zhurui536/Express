package main.presentation.financeui.listener;

import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.tool.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public MenuListener(FinanceFrame ui) {
        this.ui = ui;
        bankAcManageTool = new BankAccountManagementTool(ui);
        payTool = new PayTool(ui);
        receiptTool = new ReceiptTool(ui);
        reportTool = new ReportTool(ui);
        initTool = new InitTool(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();

        if (button == ui.getButton("账户管理")) {
            ui.paintData(new JPanel());
            ui.replaceTool(bankAcManageTool);
        } else if (button == ui.getButton("付款")) {
            ui.paintData(new JPanel());
            ui.replaceTool(payTool);
        } else if (button == ui.getButton("收款")) {
            ui.paintData(new JPanel());
            ui.replaceTool(receiptTool);
        } else if (button == ui.getButton("报表查看")) {
            ui.paintData(new JPanel());
            ui.replaceTool(reportTool);
        } else if (button == ui.getButton("期初建账")) {
            ui.paintData(new JPanel());
            ui.replaceTool(initTool);
        } else {
            System.err.println("error");
        }

    }
}
