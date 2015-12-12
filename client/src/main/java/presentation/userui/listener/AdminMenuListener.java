package presentation.userui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.userui.AdminFrame;
import presentation.userui.tool.AdminTool;

public class AdminMenuListener implements ActionListener {
	private AdminFrame ui;
	
	public AdminMenuListener(AdminFrame ui){
		this.ui = ui;
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
		}
		if(i==1){
			ui.dispose();
			System.exit(0);
		}
	}

}
