package main.presentation.billui.listener;

import java.awt.event.ActionEvent;

import main.bussinesslogic.billbl.BillBLController;
import main.bussinesslogic.util.ResultMessage;
import main.presentation.storeui.listener.ToolListener;
import main.presentation.storeui.tool.GetButtonOfTool;

public class BillJudgeToolListener extends ToolListener {
	private BillBLController bc;
	
	public BillJudgeToolListener(BillBLController bc){
		this.bc = bc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		GetButtonOfTool tool = super.getTool();
		
		for(i=0;i<tool.getNumOfButton();i++){
			if(e.getSource() == tool.getButton(i)){
				break;
			}
		}
		
		if(i==0){
			ResultMessage result = bc.approves();
			if(result.getKey().equals("success")){
				result = bc.getBills();
			}
		}
		else if(i==1){
			//将窗口中的tool和datapanel移除，并将窗口返回空闲状态
		}
	}

}
