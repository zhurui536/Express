package presentation.financeui.listener.toollistener;

import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.ProfitPanel;
import presentation.financeui.datapanel.StatementPanel;
import presentation.financeui.dialog.StatementDialog;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.tool.ToolPanel;
import util.ResultMessage;
import util.Time;
import vo.financevo.ProfitListVO;
import vo.financevo.StatementVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

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
        ui.paintData(new JPanel());
        
        if (button == toolPanel.getButton("profit")) {
            processProfit();
        } else if (button == toolPanel.getButton("statement")) {
            StatementDialog dialog = new StatementDialog(ui);
            dialog.setVisible(true);
            Time sTime = dialog.getStartTime();
            Time eTime = dialog.getEndTime();
            processStatement(sTime, eTime);
        } else if (button == toolPanel.getButton("profitExport")) {
        	OutputStream out = getPath();
        	profitExport(out);
        } else if (button == toolPanel.getButton("statementExport")) {
        	OutputStream out = getPath();
        	statementExport(out); 
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
        }
        else {
            System.out.println("0");
        }
    }

    private OutputStream getPath() {
    	JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setDe
//    	fileChooser.showOpenDialog(ui);
        fileChooser.showSaveDialog(ui);
//        fileChooser.setSelectedFile(new File("hello.txt"));
    	OutputStream out = null;
		try {
			out = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath());
			System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return out;
	}

	private void statementExport(OutputStream out) {
		ResultMessage msg = financeController.statementToExcel(out);
		if (isFail(msg)) {
            // TODO
        } else {
        	new WarningDialog(ui, "导出成功！");
        }
	}

	private void profitExport(OutputStream out) {
		ResultMessage msg = financeController.profitListToExcel(out);
		if (isFail(msg)) {
            // TODO
        } else {
        	new WarningDialog(ui, "导出成功！");
        }
	}

	private void processStatement(Time sTime, Time eTime) {
    	ResultMessage msg = financeController.showStatement(sTime, eTime);
        if (isFail(msg)) {
            // TODO
        } else {
        	StatementVO statementVO = (StatementVO) msg.getValue();
            StatementPanel statementPanel = new StatementPanel(statementVO);
            System.out.println("success");
            ui.paintData(statementPanel);
        }
	}

	private void processProfit() {
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
    
    public static void main(String args[]) {
    	
    }
}
