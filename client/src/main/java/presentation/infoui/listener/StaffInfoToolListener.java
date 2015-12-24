package presentation.infoui.listener;

import bussinesslogicservice.infoblservice.StaffMessageMaintenanceBLService;
import presentation.WarningDialog;
import presentation.infoui.datapanel.StaffMessageDataPane;
import presentation.infoui.inputframe.StaffIDInputFrame;
import presentation.infoui.inputframe.StaffInfoInputFrame;
import presentation.mainui.ToolPane;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.StaffMessageVO;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class StaffInfoToolListener extends ToolListener {
	private StaffMessageMaintenanceBLService bl;
	private ManagerFrame ui;
	
	public StaffInfoToolListener(ManagerFrame ui){
		this.ui = ui;
		this.bl = ui.getStaffMessageController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ToolPane tool = super.getTool();
		
		int i=0;
		for(;i<tool.getNumOfButton();i++){
			if(e.getSource() == tool.getButton(i)){
				break;
			}
		}
		
		if(i==0){
			ResultMessage result = bl.getStaff();
			if(result.getKey().equals("success")){
				StaffMessageDataPane data = new StaffMessageDataPane((ArrayList<StaffMessageVO>) result.getValue());
				ui.paintdata(data);
			}
		}
		if(i==1){
			StaffInfoInputFrame frame = new StaffInfoInputFrame(this);
			frame.setVisible(true);
		}
		if(i==2){
			StaffIDInputFrame frame = new StaffIDInputFrame(this, 0);
			frame.setVisible(true);
		}
		if(i==3){
			StaffIDInputFrame frame = new StaffIDInputFrame(this, 1);
			frame.setVisible(true);
		}
		if(i==4){
			ui.replaceTool(null);
			ui.paintdata(null);
		}
	}
	
	public boolean getID(String id, int condition){
		if(condition == 0){
			ResultMessage result = bl.delStaffMessage(id);
			
			if(result.getKey().equals("SUCCESS")){
				result = bl.getStaff();
				if(result.getKey().equals("success")){
					StaffMessageDataPane data = new StaffMessageDataPane((ArrayList<StaffMessageVO>) result.getValue());
					ui.paintdata(data);
				}
				return true;
			}
			else{
				WarningDialog warning = new WarningDialog(ui, result.getKey());
				return false;
			}
		}
		if(condition == 1){
			ResultMessage result = bl.showStaffMessage(id);
			
			if(result.getKey().equals("SUCCESS")){
				StaffMessageVO vo = (StaffMessageVO) result.getValue();
				StaffInfoInputFrame frame = new StaffInfoInputFrame(this, vo);
				frame.setVisible(true);
				return true;
			}
			else{
				WarningDialog warning = new WarningDialog(ui, result.getKey());
				return false;
			}
		}
		
		return false;
	}
	
	public boolean getInput(StaffMessageVO vo, int condition){
		ResultMessage result = null;
		if(condition == 0){
			result = bl.addStaffMessage(vo);
		}
		if(condition == 1){
			result = bl.modStaffMessage(vo);
		}
		
		if(result.getKey().equals("SUCCESS")){
			result = bl.getStaff();
			if(result.getKey().equals("success")){
				StaffMessageDataPane data = new StaffMessageDataPane((ArrayList<StaffMessageVO>) result.getValue());
				ui.paintdata(data);
			}
			return true;
		}
		else{
			WarningDialog warning = new WarningDialog(ui, result.getKey());
			return false;
		}
	}
}
