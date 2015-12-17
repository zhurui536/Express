package presentation.strategyui.listener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import presentation.ToolPane;
import presentation.WarningFrame;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import presentation.strategyui.datapanel.SalaryStrategyDataPane;
import presentation.strategyui.datapanel.SalaryStrategyShowPane;
import util.ResultMessage;
import vo.StaffMessageVO;

public class SalaryToolListener extends ToolListener {
	private ManagerFrame ui;
	private StrategySalaryBLService bl;
	
	public SalaryToolListener(ManagerFrame ui){
		this.ui = ui;
		this.bl = ui.getStrategySalaryController();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ToolPane tool = super.getTool();
		
		int i=0;
		for(;i<tool.getNumOfButton();i++){
			if(arg0.getSource() == tool.getButton(i)){
				break;
			}
		}
		
		if(i==0){
			SalaryStrategyDataPane data = new SalaryStrategyDataPane(ui);
			ui.paintdata(data);
		}
		if(i==1){
			ResultMessage result = bl.getSalary();
			if(result.getKey().equals("success")){
				SalaryStrategyShowPane data = new SalaryStrategyShowPane((ArrayList<StaffMessageVO>) result.getValue());
				ui.paintdata(data);
			}
			else{
				WarningFrame warning = new WarningFrame(result.getKey());
			}
		}
		if(i==2){
			ui.paintdata(null);
			ui.replaceTool(null);
		}
	}
}
