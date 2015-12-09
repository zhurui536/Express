package main.presentation.managerui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.presentation.billui.listener.BillJudgeToolListener;
import main.presentation.billui.tool.BillJudgeTool;
import main.presentation.managerui.ManagerFrame;
import main.presentation.strategyui.datapanel.SalaryStrategyDataPane;
import main.presentation.strategyui.tool.StrategyTool;

public class MenuListener implements ActionListener {
	private ManagerFrame ui;
	
	public MenuListener(ManagerFrame ui){
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0;
		
		for(i=0;i<8;i++){
			if(e.getSource() == ui.getButton(i))
				break;
		}
		if(i==0){
			StrategyTool tool = new StrategyTool(this.ui);
			ui.replaceTool(tool);
		}
		if(i==1){
			SalaryStrategyDataPane data = new SalaryStrategyDataPane(ui);
			ui.paintdata(data);
		}
		if(i==2){//点击了审批单据
			BillJudgeToolListener listener = new BillJudgeToolListener(ui);
			BillJudgeTool tool = new BillJudgeTool(listener);
			listener.setTool(tool);
			ui.replaceTool(tool);
		}
		
		if(i==7){
			ui.close();
		}
	}

}
