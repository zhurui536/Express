package main.presentation.financeui.listener.toollistener;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.FinanceBLService;
import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.datapanel.ProfitPanel;
import main.presentation.financeui.dialog.StatementDialog;
import main.presentation.financeui.listener.ToolListener;
import main.presentation.financeui.tool.ToolPanel;
import main.vo.storevo.ProfitListVO;

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
            processProfit();
        } else if (button == toolPanel.getButton("statement")) {
            StatementDialog dialog = new StatementDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
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
