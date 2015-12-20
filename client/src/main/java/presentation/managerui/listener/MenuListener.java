package presentation.managerui.listener;

import presentation.billui.listener.BillJudgeToolListener;
import presentation.billui.tool.BillJudgeTool;
import presentation.infoui.listener.InstitutionInfoToolListener;
import presentation.infoui.listener.StaffInfoToolListener;
import presentation.infoui.tool.InstitutionInfoTool;
import presentation.infoui.tool.StaffInfoTool;
import presentation.managerui.ManagerFrame;
import presentation.strategyui.listener.SalaryToolListener;
import presentation.strategyui.listener.StrategyToolListener;
import presentation.strategyui.tool.SalaryTool;
import presentation.strategyui.tool.StrategyTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
	private ManagerFrame ui;
	
	public MenuListener(ManagerFrame ui){
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0;
		
		for(i=0;i<6;i++){
			if(e.getSource() == ui.getButton(i))
				break;
		}
		if(i==0){
			StrategyToolListener tl = new StrategyToolListener(ui);
			StrategyTool tool = new StrategyTool(tl);
			tl.setTool(tool);
			ui.replaceTool(tool);
			ui.paintdata(null);
		}
		if(i==1){
			SalaryToolListener tl = new SalaryToolListener(ui);
			SalaryTool tool = new SalaryTool(tl);
			tl.setTool(tool);
			ui.replaceTool(tool);
			ui.paintdata(null);
		}
		if(i==2){//点击了审批单据
			BillJudgeToolListener listener = new BillJudgeToolListener(ui);
			BillJudgeTool tool = new BillJudgeTool(listener);
			listener.setTool(tool);
			ui.replaceTool(tool);
			ui.paintdata(null);
		}
		if(i==3){//点击了机构信息管理
			InstitutionInfoToolListener listener = new InstitutionInfoToolListener(ui);
			InstitutionInfoTool tool = new InstitutionInfoTool(listener);
			listener.setTool(tool);
			ui.replaceTool(tool);
			ui.paintdata(null);
		}
		if(i==4){//点击了人员信息管理
			StaffInfoToolListener listener = new StaffInfoToolListener(ui);
			StaffInfoTool tool = new StaffInfoTool(listener);
			listener.setTool(tool);
			ui.replaceTool(tool);
			ui.paintdata(null);
		}
		if(i==5){
			ui.close();
		}
	}

}
