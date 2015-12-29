package presentation.managerui.listener;

import bussinesslogic.infobl.SystemlogBL;
import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
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
import presentation.userui.data.LogDataPane;
import vo.SystemlogVO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuListener implements ActionListener {
	private ManagerFrame ui;
	
	public MenuListener(ManagerFrame ui){
		this.ui = ui;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0;
		
		for(i=0;i<7;i++){
			if(e.getSource() == ui.getButton(i))
				break;
		}
		//更改菜单中的按钮显示
		ui.refreshMenu();
		ui.getButton(i).clicked();
		
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
			SystemlogMaintenanceBLService temp = new SystemlogBL();
			ArrayList<SystemlogVO> list = (ArrayList<SystemlogVO>) temp.showSystemlog().getValue();
			ui.paintdata(new LogDataPane(list));
			ui.replaceTool(null);
		}
		if(i==6){
			ui.close();
		}
	}

}
