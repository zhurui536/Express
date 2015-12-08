package main.presentation.financeui.listener;

import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.tool.BankAccountManagementTool;
import main.presentation.financeui.tool.ToolPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/8
 */

public class MenuListener implements ActionListener {

    private FinanceFrame ui;

    private ToolPanel bankAcManageTool;

    public MenuListener(FinanceFrame ui) {
        this.ui = ui;
        bankAcManageTool = new BankAccountManagementTool(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();

        if (button == ui.getButton("账户管理")) {
            ui.replaceTool(bankAcManageTool);
        } else if (button == ui.getButton("付款")) {
            System.out.println("1");
        } else if (button == ui.getButton("收款")) {
            System.out.println("2");
        } else if (button == ui.getButton("报表查看")) {
            System.out.println("3");
        } else if (button == ui.getButton("期初建账")) {

        } else {
            System.out.println("0");
        }

    }
}
