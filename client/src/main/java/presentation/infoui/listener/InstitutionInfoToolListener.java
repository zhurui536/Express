package presentation.infoui.listener;

import bussinesslogicservice.infoblservice.InstitutionMessageMaintenanceBLService;
import presentation.WarningDialog;
import presentation.infoui.datapanel.InstitutionMessageDataPane;
import presentation.infoui.inputframe.InstitutionIDInputFrame;
import presentation.infoui.inputframe.InstitutionInfoInputFrame;
import presentation.mainui.component.MyTool;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.InstitutionMessageVO;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InstitutionInfoToolListener extends ToolListener {
	private ManagerFrame ui;
	private InstitutionMessageMaintenanceBLService bl;
	
	public InstitutionInfoToolListener(ManagerFrame ui){
		this.ui = ui;
		this.bl = ui.getInstitutionMessageController();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		MyTool tool = super.getTool();
		
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
	
	@SuppressWarnings("unchecked")
	public boolean getID(String id, int condition){
		if(condition == 0){//0代表删除该机构
			ResultMessage result = bl.delInstitutionMessage(id);
			
			if(result.getKey().equals("SUCCESS")){
				result = bl.getInstitutionMessage();
				if(result.getKey().equals("SUCCESS")){
					InstitutionMessageDataPane data = new InstitutionMessageDataPane((ArrayList<InstitutionMessageVO>) result.getValue());
					ui.paintdata(data);
				}
				else{
					if(result.getKey().equals("FAIL")){
						new WarningDialog(ui, "获取机构信息失败！");
					}
				}
				return true;
			}
			else{
				if(result.getKey().equals("NO_EXIST")){
					new WarningDialog(ui, "机构不存在！");
				}
				if(result.getKey().equals("staffininst")){
					new WarningDialog(ui, "无法删除有员工的机构！");
				}
				if(result.getKey().equals("FAIL")){
					new WarningDialog(ui, "网络连接出错！");
				}
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
				if(result.getKey().equals("FAIL")){
					new WarningDialog(ui, "网络连接出错！");
				}
				if(result.getKey().equals("NO_EXIST")){
					new WarningDialog(ui, "机构不存在！");
				}
				return false;
			}
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
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
			if(result.getKey().equals("FAIL")){
				new WarningDialog(ui, "网络连接出错！");
			}
			if(result.getKey().equals("EXIST")){
				new WarningDialog(ui, "机构已存在，无法新建");
			}
			return false;
		}
	}
}
