package presentation.financeui.listener.toollistener;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.FinanceFrame;
import presentation.financeui.dialog.PayDialog;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.tool.ToolPanel;

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
        ToolPanel toolPanel = ui.getToolPanel();
        ui.paintData(new JPanel());
        
        if (button == toolPanel.getButton("create")) {
            PayDialog dialog = new PayDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
        }
    }
    
}
