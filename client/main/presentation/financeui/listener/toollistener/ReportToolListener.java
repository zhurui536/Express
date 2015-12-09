package main.presentation.financeui.listener.toollistener;

import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.listener.ToolListener;
import main.presentation.financeui.tool.ToolPanel;

import java.awt.event.ActionEvent;

/**
 * Created by Away
 * 2015/12/9
 */

public class ReportToolListener extends ToolListener {

    public ReportToolListener(FinanceFrame ui) {
        super(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        ToolPanel toolPanel = ui.getToolPanel();

        if (button == toolPanel.getButton("profit")) {

        } else if (button == toolPanel.getButton("statement")) {

        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
        }
        else {
            System.out.println("0");
        }
    }
}
