package presentation.storeui.listener.toollistener;

import java.awt.event.ActionEvent;

import presentation.ToolPane;
import presentation.WarningFrame;
import presentation.storeui.StoreFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import bussinesslogicservice.storeblservice.StoreBLService;

public class VerificationToolListener extends ToolListener {

	private StoreBLService sc;
	private StoreFrame ui;
	
	public VerificationToolListener(StoreFrame ui) {
		this.ui = ui;
		this.sc = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ToolPane tool = super.getTool();
		int i;
		
		for(i=0;i<tool.getNumOfButton();i++){
			if(e.getSource() == tool.getButton(i)){
				break;
			}
		}
		
		if(i==0){
			ResultMessage result = sc.endVerification(0);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				WarningFrame frame = new WarningFrame(result);
			}
		}
		else{
			sc.endVerification(1);
			ui.replaceTool(null);
			ui.paintdata(null);
		}
	}

}
