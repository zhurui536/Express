package main.presentation.financeui.listener.toollistener;

import main.bussinesslogicservice.financeblservice._stub.FinanceBLService;
import main.presentation.financeui.listener.ToolListener;
import main.presentation.financeui.tool.ToolPanel;

import java.awt.event.ActionEvent;

/**
 * Created by Away
 * 2015/12/8
 */

public class CreateAccountingToolListener extends ToolListener {

    public CreateAccountingToolListener(ToolPanel toolPanel, FinanceBLService financeController) {
        super(toolPanel, financeController);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
