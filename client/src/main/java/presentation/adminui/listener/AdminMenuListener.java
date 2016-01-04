package presentation.adminui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bussinesslogicservice.adminblservice.AdminBLService;
import presentation.WarningDialog;
import presentation.adminui.AdminFrame;
import presentation.adminui.data.AdminDataPane;
import presentation.adminui.tool.AdminTool;
import util.ResultMessage;
import vo.UserVO;

public class AdminMenuListener implements ActionListener {
	private AdminFrame ui;
	private AdminBLService bl;
	public AdminMenuListener(AdminFrame ui){
		this.ui = ui;
		this.bl = ui.getController();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		
		for(i=0;i<2;i++){
			if(e.getSource() == ui.getButton(i))
				break;
		}
		
		ui.refreshMenu();
		ui.getButton(i).clicked();
		if(i==0){
			AdminToolListener tl = new AdminToolListener(ui);
			AdminTool tool = new AdminTool(tl);
			tl.setTool(tool);
			ui.replaceTool(tool);
			
			ResultMessage result = bl.getUser();
			if(result.getKey().equals("success")){
				AdminDataPane data = new AdminDataPane((ArrayList<UserVO>) result.getValue(), tl);
				ui.paintdata(data);
			}
			else{
				new WarningDialog(ui, result);
			}
		}
		if(i==1){
			ui.dispose();
			System.exit(0);
		}
	}

}
