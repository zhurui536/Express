package presentation.financeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.FinanceFrame;
import presentation.mainui.ExpressFrame;
import presentation.managerui.ManagerFrame;

/**
 * Created by Away
 * 2015/12/8
 */

public abstract class ToolListener implements ActionListener {

    protected ExpressFrame ui;
    
    protected FinanceBLService financeController;
    
    public ToolListener(ExpressFrame ui) {
        this.ui = ui;
        if (ui instanceof FinanceFrame) {
        	this.financeController = ((FinanceFrame)ui).getFinanceController();
        } else {
        	this.financeController = ((ManagerFrame)ui).getFinanceController();
        }
    }

    @Override
    abstract public void actionPerformed(ActionEvent e);
}
