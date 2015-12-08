package main.presentation.storeui.listener.toollistener;

import java.awt.event.ActionEvent;
import java.util.Calendar;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.storeblservice.StoreBLService;
import main.presentation.storeui.StoreFrame;
import main.presentation.storeui.datapanel.CheckDataPane;
import main.presentation.storeui.inputframe.CheckInputFrame;
import main.presentation.storeui.listener.ToolListener;
import main.presentation.storeui.tool.GetButtonOfTool;
import main.vo.storevo.CheckVO;

public class CheckToolListener extends ToolListener {

	private StoreBLService sc;
	private StoreFrame ui;
	
	public CheckToolListener(StoreFrame ui) {
		this.ui = ui;
		this.sc = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GetButtonOfTool tool = super.getTool();
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
			
			return false;
		}
	}

}
