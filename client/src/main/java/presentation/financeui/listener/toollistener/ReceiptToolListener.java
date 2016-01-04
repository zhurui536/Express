package presentation.financeui.listener.toollistener;

import java.awt.event.ActionEvent;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.FinanceFrame;
import presentation.financeui.dialog.ReceiptDialog;
import presentation.financeui.dialog.SettleDialog;
import presentation.financeui.listener.ToolListener;
import presentation.mainui.component.MyTool;

/**
 * 查看收款单监听
 * Created by Away
 * 2015/12/9
 */

public class ReceiptToolListener extends ToolListener {
	
	FinanceBLService financeController;
	
    public ReceiptToolListener(FinanceFrame ui) {
        super(ui);
        financeController = ui.getFinanceController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	FinanceFrame ui = (FinanceFrame) this.ui;
        Object button = e.getSource();
        MyTool toolPanel = ui.getTool();
        ui.paintdata(null);
        
        if (button == toolPanel.getButton(0)) {
            ReceiptDialog dialog = new ReceiptDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton(1)) {
        	SettleDialog dialog = new SettleDialog(ui);
            dialog.setVisible(true);
        }
    }
}
