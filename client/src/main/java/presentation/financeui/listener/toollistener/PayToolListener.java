package presentation.financeui.listener.toollistener;

import presentation.financeui.FinanceFrame;
import presentation.financeui.dialog.PayDialog;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.tool.ToolPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Away
 * 2015/12/9
 */

public class PayToolListener extends ToolListener {

    public PayToolListener(FinanceFrame ui) {
        super(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        ToolPanel toolPanel = ui.getToolPanel();

        if (button == toolPanel.getButton("create")) {
            ui.paintData(new JPanel());
            PayDialog dialog = new PayDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
            ui.paintData(new JPanel());
        } else {
            System.out.println("0");
        }
    }
}
