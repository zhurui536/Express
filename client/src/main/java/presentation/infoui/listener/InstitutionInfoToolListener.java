package presentation.infoui.listener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import presentation.ToolPane;
import presentation.WarningFrame;
import presentation.infoui.datapanel.InstitutionMessageDataPane;
import presentation.infoui.inputframe.InstitutionIDInputFrame;
import presentation.infoui.inputframe.InstitutionInfoInputFrame;
import presentation.infoui.inputframe.StaffIDInputFrame;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.InstitutionMessageVO;
import vo.StaffMessageVO;

public class InstitutionInfoToolListener extends ToolListener {
	private ManagerFrame ui;
	private InstitutionMessageMaintenanceBLService bl;
	
	public InstitutionInfoToolListener(ManagerFrame ui){
		this.ui = ui;
		this.bl = ui.getInstitutionMessageController();
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
			ResultMessage result = bl.getInstitutionMessage();
			if(result.getKey().equals("SUCCESS")){
				InstitutionMessageDataPane data = new InstitutionMessageDataPane((ArrayList<InstitutionMessageVO>) result.getValue());
				ui.paintdata(data);
			}
		}
		if(i==1){
			InstitutionInfoInputFrame frame = new InstitutionInfoInputFrame(this);
			frame.setVisible(true);
		}
		if(i==2){
			InstitutionIDInputFrame frame = new InstitutionIDInputFrame(this, 0);
			frame.setVisible(true);
		}
		if(i==3){
			InstitutionIDInputFrame frame = new InstitutionIDInputFrame(this, 1);
			frame.setVisible(true);
		}
		if(i==4){
			ui.replaceTool(null);
			ui.paintdata(null);
		}
	}
	
	public boolean getID(String id, int condition){
		if(condition == 0){
			ResultMessage result = bl.delInstitutionMessage(id);
			
			if(result.getKey().equals("SUCCESS")){
				result = bl.getInstitutionMessage();
				if(result.getKey().equals("SUCCESS")){
					InstitutionMessageDataPane data = new InstitutionMessageDataPane((ArrayList<InstitutionMessageVO>) result.getValue());
					ui.paintdata(data);
				}
				return true;
			}
			else{
				WarningFrame warning = new WarningFrame(result.getKey());
				return false;
			}
		}
		if(condition == 1){
			ResultMessage result = bl.showInstitutionMessage(id);
			
			if(result.getKey().equals("SUCCESS")){
				InstitutionMessageVO vo = (InstitutionMessageVO) result.getValue();
				InstitutionInfoInputFrame frame = new InstitutionInfoInputFrame(vo, this);
				frame.setVisible(true);
				return true;
			}
			else{
				WarningFrame warning = new WarningFrame(result.getKey());
				return false;
			}
		}
		
		return false;
	}
	
	public boolean getInput(InstitutionMessageVO vo, int condition){
		ResultMessage result = null;
		if(condition == 0){
			result = bl.addInstitutionMessage(vo);
		}
		if(condition == 1){
			result = bl.modInstitutionMessage(vo);
		}
		
		if(result.getKey().equals("SUCCESS")){
			result = bl.getInstitutionMessage();
			if(result.getKey().equals("SUCCESS")){
				InstitutionMessageDataPane data = new InstitutionMessageDataPane((ArrayList<InstitutionMessageVO>) result.getValue());
				ui.paintdata(data);
			}
			return true;
		}
		else{
			WarningFrame warning = new WarningFrame(result.getKey());
			return false;
		}
	}
}
