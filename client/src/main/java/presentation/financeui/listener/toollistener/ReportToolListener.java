package presentation.financeui.listener.toollistener;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import bussinesslogicservice.financeblservice.FinanceBLService;
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

/**
 * Created by Away
 * 2015/12/9
 */

public class ReportToolListener extends ToolListener {

    FinanceFrame ui;
    
    FinanceBLService financeController;
    
    public ReportToolListener(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
        this.financeController = ui.getFinanceController();
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
            Time sTime = dialog.getStartTime();
            Time eTime = dialog.getEndTime();
            processStatement(sTime, eTime);
            dialog.setVisible(true);
        } else if (button == toolPanel.getButton("profitExport")) {
        	JFileChooser fileChooser = new JFileChooser();
        	fileChooser.showOpenDialog(ui);
        	OutputStream out = null;
			try {
				out = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
        	profitExport(out);
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
        }
        else {
            System.out.println("0");
        }
    }

    private void profitExport(OutputStream out) {
		ResultMessage msg = financeController.profitListToExcel(out);
		
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
