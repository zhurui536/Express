package main.presentation.financeui.listener.toollistener;

import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.dialog.BankAccountAddDialog;
import main.presentation.financeui.dialog.BankAccountDelDialog;
import main.presentation.financeui.dialog.BankAccountFindDialog;
import main.presentation.financeui.dialog.BankAccountUpdateDialog;
import main.presentation.financeui.listener.ToolListener;
import main.presentation.financeui.tool.ToolPanel;

import javax.swing.*;
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
            ui.paintData(new JPanel());
            BankAccountAddDialog dialog = new BankAccountAddDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("del")) {
            ui.paintData(new JPanel());
            BankAccountDelDialog dialog = new BankAccountDelDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("find")) {
            ui.paintData(new JPanel());
            BankAccountFindDialog dialog = new BankAccountFindDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("update")) {
            ui.paintData(new JPanel());
            BankAccountUpdateDialog dialog = new BankAccountUpdateDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
            ui.paintData(new JPanel());
        } else {
            System.out.println("0");
        }
    }
}
