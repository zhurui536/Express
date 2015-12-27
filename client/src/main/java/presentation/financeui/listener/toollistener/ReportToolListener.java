package presentation.financeui.listener.toollistener;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;

import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.ProfitPanel;
import presentation.financeui.datapanel.StatementPanel;
import presentation.financeui.dialog.StatementDialog;
import presentation.financeui.listener.ToolListener;
import presentation.mainui.component.MyTool;
import util.ResultMessage;
import util.Time;
import vo.financevo.ProfitListVO;
import vo.financevo.StatementVO;

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
        MyTool toolPanel = ui.getTool();
        ui.paintdata(null);
        
        if (button == toolPanel.getButton(0)) {
            processProfit();
        } else if (button == toolPanel.getButton(2)) {
            StatementDialog dialog = new StatementDialog(ui);
            dialog.setVisible(true);
            Time sTime = dialog.getStartTime();
            Time eTime = dialog.getEndTime();
            processStatement(sTime, eTime);
        } else if (button == toolPanel.getButton(1)) {
        	OutputStream out = getPath();
            if (out != null) {
                profitExport(out);
            }
        } else if (button == toolPanel.getButton(3)) {
        	OutputStream out = getPath();
            if (out != null) {
                statementExport(out);
            }
        }
    }

    private OutputStream getPath() {
    	JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(ui);
    	OutputStream out;
		try {
			out = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath());
			System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
		} catch (FileNotFoundException e1) {
            out = null;
			e1.printStackTrace();
		}
		return out;
	}

	private void statementExport(OutputStream out) {
		ResultMessage msg = financeController.statementToExcel(out);
		if (isFail(msg)) {
            new WarningDialog(ui, "请先生成经营情况表！");
        } else {
        	new WarningDialog(ui, "导出成功！");
        }
	}

	private void profitExport(OutputStream out) {
		ResultMessage msg = financeController.profitListToExcel(out);
		if (isFail(msg)) {
            new WarningDialog(ui, "请先生成成本收益表！");
        } else {
        	new WarningDialog(ui, "导出成功！");
        }
	}

	private void processStatement(Time sTime, Time eTime) {
    	ResultMessage msg = financeController.showStatement(sTime, eTime);
        if (isFail(msg)) {
            new WarningDialog(ui, "生成失败！");
        	System.out.println(msg.getKey());
        } else {
        	StatementVO statementVO = (StatementVO) msg.getValue();
            StatementPanel statementPanel = new StatementPanel(statementVO);
            System.out.println("success");
            ui.paintdata(statementPanel);
            new WarningDialog(ui, "生成成功！");
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
        }
    }

    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }
    
    public static void main(String args[]) {
    	
    }
}
