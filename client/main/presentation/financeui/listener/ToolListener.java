package main.presentation.financeui.listener;

import main.presentation.financeui.FinanceFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/8
 */

public abstract class ToolListener implements ActionListener {

    protected FinanceFrame ui;

    public ToolListener(FinanceFrame ui) {
        this.ui = ui;
    }

    @Override
    abstract public void actionPerformed(ActionEvent e);
}
