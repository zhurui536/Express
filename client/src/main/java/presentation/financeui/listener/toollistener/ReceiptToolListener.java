package presentation.financeui.listener.toollistener;

import presentation.financeui.FinanceFrame;
import presentation.financeui.dialog.ReceiptDialog;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.tool.ToolPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Away
 * 2015/12/9
 */

public class ReceiptToolListener extends ToolListener {

    public ReceiptToolListener(FinanceFrame ui) {
        super(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        ToolPanel toolPanel = ui.getToolPanel();

        if (button == toolPanel.getButton("show")) {
            ui.paintData(new JPanel());
            ReceiptDialog dialog = new ReceiptDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
            ui.paintData(new JPanel());
        } else {
            System.out.println("0");
        }
    }
}
