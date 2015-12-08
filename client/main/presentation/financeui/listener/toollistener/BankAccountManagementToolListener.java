package main.presentation.financeui.listener.toollistener;

import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.dialog.BankAccountAddDialog;
import main.presentation.financeui.dialog.BankAccountDelDialog;
import main.presentation.financeui.dialog.BankAccountFindDialog;
import main.presentation.financeui.listener.ToolListener;
import main.presentation.financeui.tool.ToolPanel;

import java.awt.event.ActionEvent;

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
        } else if (button == toolPanel.getButton("del")) {
            BankAccountDelDialog dialog = new BankAccountDelDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("find")) {
            BankAccountFindDialog dialog = new BankAccountFindDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("update")) {
            System.out.println("u");
        } else if (button == toolPanel.getButton("back")) {
            System.out.println("b");
        } else {
            System.out.println("0");
        }
    }
}
