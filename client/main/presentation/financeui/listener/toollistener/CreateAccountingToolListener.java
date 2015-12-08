package main.presentation.financeui.listener.toollistener;

import main.bussinesslogicservice.financeblservice._stub.FinanceBLService;
import main.presentation.financeui.FinanceFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/8
 */

public class CreateAccountingToolListener implements ActionListener {

    private FinanceFrame ui;

    private FinanceBLService financeController;

    public CreateAccountingToolListener(FinanceFrame ui, FinanceBLService financeController) {
        this.ui = ui;
        this.financeController = financeController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
