package main.presentation.financeui.listener;

import main.bussinesslogicservice.financeblservice._stub.FinanceBLService;
import main.presentation.financeui.tool.ToolPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/8
 */

public abstract class ToolListener implements ActionListener {

    protected ToolPanel toolPanel;

    protected FinanceBLService financeController;

    public ToolListener(ToolPanel toolPanel, FinanceBLService financeController) {
        this.toolPanel = toolPanel;
        this.financeController = financeController;
    }

    @Override
    abstract public void actionPerformed(ActionEvent e);
}
