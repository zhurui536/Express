package presentation.storeui.listener.toollistener;

import java.awt.event.ActionEvent;
import java.util.Calendar;

import presentation.ToolPane;
import presentation.WarningFrame;
import presentation.storeui.StoreFrame;
import presentation.storeui.datapanel.CheckDataPane;
import presentation.storeui.inputframe.CheckInputFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.storevo.CheckVO;
import bussinesslogicservice.storeblservice.StoreBLService;

public class CheckToolListener extends ToolListener {

	private StoreBLService sc;
	private StoreFrame ui;
	
	public CheckToolListener(StoreFrame ui) {
		this.ui = ui;
		this.sc = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ToolPane tool = super.getTool();
		int i;
		
		for(i=0;i<tool.getNumOfButton();i++){
			if(e.getSource() == tool.getButton(i))
				break;
		}
		
		if(i==0){
			CheckInputFrame frame = new CheckInputFrame(this);
			frame.setVisible(true);
		}
		if(i==1){
			sc.endCheck();
			ui.replaceTool(null);
			ui.paintdata(null);
		}
		
	}
	
	public boolean getInput(Calendar start, Calendar end){
		ResultMessage result = sc.check(start, end);
		if(result.getKey().equals("success")){
			CheckVO vo = (CheckVO) result.getValue();
			ui.paintdata(new CheckDataPane(vo));
			return true;
		}
		else{
			//提示错误
			WarningFrame frame = new WarningFrame(result);
			return false;
		}
	}

}
