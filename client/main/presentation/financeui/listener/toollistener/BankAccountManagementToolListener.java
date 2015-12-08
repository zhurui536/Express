package main.presentation.financeui.listener.toollistener;

import main.bussinesslogicservice.financeblservice._stub.FinanceBLService;
import main.presentation.financeui.listener.ToolListener;
import main.presentation.financeui.tool.ToolPanel;

import java.awt.event.ActionEvent;

/**
 * Created by Away
 * 2015/12/8
 */

public class BankAccountManagementToolListener extends ToolListener {

    public BankAccountManagementToolListener(ToolPanel toolPanel, FinanceBLService financeController) {
        super(toolPanel, financeController);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();

        if (button == toolPanel.getButton("add")) {
            System.out.println("add");
        } else if (button == toolPanel.getButton("del")) {
            System.out.println("del");
        } else if (button == toolPanel.getButton("find")) {
            System.out.println("f");
        } else if (button == toolPanel.getButton("update")) {
            System.out.println("u");
        } else if (button == toolPanel.getButton("back")) {
            System.out.println("b");
        } else {
            System.out.println("0");
        }
    }
}
