package presentation.userui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bussinesslogicservice.adminblservice.AdminBLService;
import presentation.WarningFrame;
import presentation.userui.AdminFrame;
import presentation.userui.data.AdminDataPane;
import presentation.userui.tool.AdminTool;
import util.ResultMessage;
import vo.UserVO;

public class AdminMenuListener implements ActionListener {
	private AdminFrame ui;
	private AdminBLService bl;
	public AdminMenuListener(AdminFrame ui){
		this.ui = ui;
		this.bl = ui.getController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		
		for(i=0;i<2;i++){
			if(e.getSource() == ui.getButton(i))
				break;
		}
		
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
				WarningFrame warning = new WarningFrame(result);
			}
		}
		if(i==1){
			ui.dispose();
			System.exit(0);
		}
	}

}