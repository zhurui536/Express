package presentation.financeui.listener.toollistener;

import java.awt.event.ActionEvent;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.FinanceFrame;
import presentation.financeui.dialog.PayDialog;
import presentation.financeui.listener.ToolListener;
import presentation.mainui.component.MyTool;

/**
 * Created by Away
 * 2015/12/9
 */

public class PayToolListener extends ToolListener {
	
	FinanceBLService financeController;
    public PayToolListener(FinanceFrame ui) {
        super(ui);
        financeController = ui.getFinanceController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        MyTool toolPanel = ui.getTool();
        ui.paintdata(null);
        
        if (button == toolPanel.getButton(0)) {
            PayDialog dialog = new PayDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton(1)) {
            ui.replaceTool(null);
        }
    }
    
}
