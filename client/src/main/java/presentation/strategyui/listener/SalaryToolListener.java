package presentation.strategyui.listener;

import bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import presentation.WarningDialog;
import presentation.mainui.ToolPane;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import presentation.strategyui.datapanel.SalaryStrategyShowPane;
import presentation.strategyui.inputframe.SalaryInputFrame;
import util.ResultMessage;
import vo.StaffMessageVO;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
			ResultMessage result = bl.getSalary();
			if(result.getKey().equals("success")){
				SalaryStrategyShowPane data = new SalaryStrategyShowPane((ArrayList<StaffMessageVO>) result.getValue(), this);
				ui.paintdata(data);
			}
			else{
				WarningDialog warning = new WarningDialog(ui, result.getKey());
			}
		}
		if(i==1){
			ResultMessage result = bl.endSalary(0);
			if(result.getKey().equals("success")){
				ui.paintdata(null);
				ui.replaceTool(null);
			}
			else{
				WarningDialog warning = new WarningDialog(ui, result.getKey());
			}
		}
		if(i==2){
			ResultMessage result = bl.endSalary(1);
			if(result.getKey().equals("success")){
				ui.paintdata(null);
				ui.replaceTool(null);
			}
			else{
				WarningDialog warning = new WarningDialog(ui, result.getKey());
			}
		}
	}
	
	public void getModify(StaffMessageVO vo){
		SalaryInputFrame input = new SalaryInputFrame(vo, this);
		input.setVisible(true);
	}
	
	public boolean getInput(StaffMessageVO vo){
		ResultMessage result = bl.modifySalary(vo);
		if(result.getKey().equals("success")){
			return true;
		}
		else{
			WarningDialog warning = new WarningDialog(ui, result.getKey());
			return false;
		}
	}
}
