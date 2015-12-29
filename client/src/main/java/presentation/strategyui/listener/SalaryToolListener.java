package presentation.strategyui.listener;

import bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import presentation.WarningDialog;
import presentation.mainui.component.MyTool;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MyTool tool = super.getTool();
		
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
				if(result.getKey().equals("internet error")){
					new WarningDialog(ui, "网络连接出错！！");
				}
				if(result.getKey().equals("dataerror")){
					new WarningDialog(ui, "数据存储出错！！");
				}
			}
		}
		if(i==1){
			ResultMessage result = bl.endSalary(0);
			if(result.getKey().equals("success")){
				ui.paintdata(null);
				ui.replaceTool(null);
			}
			else{
				if(result.getKey().equals("internet error")){
					new WarningDialog(ui, "网络连接出错！！");
				}
				if(result.getKey().equals("dataerror")){
					new WarningDialog(ui, "数据存储出错！！");
				}
			}
		}
		if(i==2){
			ResultMessage result = bl.endSalary(1);
			if(result.getKey().equals("success")){
				ui.paintdata(null);
				ui.replaceTool(null);
			}
			else{
				if(result.getKey().equals("internet error")){
					new WarningDialog(ui, "网络连接出错！！");
				}
				if(result.getKey().equals("dataerror")){
					new WarningDialog(ui, "数据存储出错！！");
				}
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
			if(result.getKey().equals("internet error")){
				new WarningDialog(ui, "网络连接出错！！");
			}
			if(result.getKey().equals("dataerror")){
				new WarningDialog(ui, "数据存储出错！！");
			}
			return false;
		}
	}
}
