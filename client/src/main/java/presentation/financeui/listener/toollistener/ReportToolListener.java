package presentation.financeui.listener.toollistener;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.ProfitPanel;
import presentation.financeui.dialog.StatementDialog;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.tool.ToolPanel;
import util.ResultMessage;
import vo.storevo.ProfitListVO;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Away
 * 2015/12/9
 */

public class ReportToolListener extends ToolListener {

    FinanceFrame ui;

    public ReportToolListener(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        ToolPanel toolPanel = ui.getToolPanel();

        if (button == toolPanel.getButton("profit")) {
            ui.paintData(new JPanel());
            processProfit();
        } else if (button == toolPanel.getButton("statement")) {
            ui.paintData(new JPanel());
            StatementDialog dialog = new StatementDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
            ui.paintData(new JPanel());
        }
        else {
            System.out.println("0");
        }
    }

    private void processProfit() {
        FinanceBLService financeController = ui.getFinanceController();
        ResultMessage msg = financeController.showProfitList();
        if (isFail(msg)) {
            // TODO
        } else {
            ProfitListVO profitListVO = (ProfitListVO) msg.getValue();
            ProfitPanel profitPanel = new ProfitPanel(profitListVO);
            ui.paintData(profitPanel);
        }
    }

    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }
}
