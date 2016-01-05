package presentation.financeui.listener.toollistener;

import java.awt.event.ActionEvent;

import javax.swing.JTable;

import presentation.WarningDialog;
import presentation.financeui.datapanel.ProfitPanel;
import presentation.financeui.dialog.StatementDialog;
import presentation.financeui.listener.ToolListener;
import presentation.mainui.ExpressFrame;
import presentation.mainui.component.MyTool;
import util.ResultMessage;
import vo.financevo.ProfitListVO;

/**
 * Created by Away
 * 2015/12/9
 */

public class ReportToolListener extends ToolListener {
    
	private JTable table;
	
	private JTable payTable;
	
	private JTable receiptTable;
	
	private StatementDialog dialog;
	
    public ReportToolListener(ExpressFrame ui) {
        super(ui);
        table = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        MyTool toolPanel = ui.getTool();
        ui.paintdata(null);
        
        if (button == toolPanel.getButton(0)) {
            processProfit();
        } else if (button == toolPanel.getButton(2)) {
        	System.err.println("akldsjf");
        	dialog = new StatementDialog(ui);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton(1)) {
        	if (table == null) {
        		new WarningDialog(ui, "请先生成成本收益表");
        	} else {
        		profitExport();
        		table = null;
        	}
        } else if (button == toolPanel.getButton(3)) {
        	if (dialog != null) {
        		payTable = dialog.getPayTable();
        		receiptTable = dialog.getReceiptTable();
        	}
            if (payTable == null || receiptTable == null) {
            	new WarningDialog(ui, "请先生成经营情况表");
            } else {
            	statementExport();
            	dialog.setEmpty();
            }
        }
    }

	private void statementExport() {
		ResultMessage msg = financeController.statementToExcel(payTable, receiptTable);
		if (isFail(msg)) {
            new WarningDialog(ui, "请先生成经营情况表！");
        } else if(msg.getKey().equals("success")) {
        	new WarningDialog(ui, "导出成功！");
        }
	}

	private void profitExport() {
		ResultMessage msg = financeController.profitListToExcel(table);
		if (isFail(msg)) {
            new WarningDialog(ui, "请先生成成本收益表！");
        } else if (msg.getKey().equals("success")) {
        	new WarningDialog(ui, "导出成功！");
        }
	}

	private void processProfit() {
        ResultMessage msg = financeController.showProfitList();
        if (isFail(msg)) {
            new WarningDialog(ui, "生成失败！");
        } else {
            ProfitListVO profitListVO = (ProfitListVO) msg.getValue();
            ProfitPanel profitPanel = new ProfitPanel(profitListVO);
            ui.paintdata(profitPanel);
            new WarningDialog(ui, "生成成功！");
            table = profitPanel.getTable();
        }
    }

    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }
    
}
