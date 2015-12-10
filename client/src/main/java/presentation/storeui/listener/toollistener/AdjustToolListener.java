package presentation.storeui.listener.toollistener;

import bussinesslogicservice.storeblservice.StoreBLService;
import presentation.storeui.StoreFrame;
import presentation.storeui.datapanel.AdjustDataPane;
import presentation.storeui.inputframe.AdjustInputFrame;
import presentation.storeui.listener.ToolListener;
import presentation.storeui.tool.GetButtonOfTool;
import util.ResultMessage;
import vo.storevo.AdjustVO;
import vo.storevo.StorePlaceVO;

import java.awt.event.ActionEvent;

public class AdjustToolListener extends ToolListener {

	private StoreBLService sc;
	private StoreFrame ui;
	
	public AdjustToolListener(StoreFrame ui) {
		this.ui = ui;
		this.sc = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i;
		GetButtonOfTool tool = super.getTool();
		
		for(i=0;i<tool.getNumOfButton();i++){
			if(arg0.getSource() == tool.getButton(i))
				break;
		}
		
		if(i==0){
			AdjustInputFrame adjust = new AdjustInputFrame(this);
			adjust.setVisible(true);
		}
		else if(i==1){
			ResultMessage result = sc.endAdjust(0);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				//提示错误
			}
		}
		else if(i==2){
			ResultMessage result = sc.endAdjust(1);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				//提示错误
			}
		}
	}
	
	public boolean getInput(int[] startplace, int[] endplace){
		StorePlaceVO vo1 = new StorePlaceVO(startplace[0], startplace[1], startplace[2], startplace[3]);
		StorePlaceVO vo2 = new StorePlaceVO(endplace[0], endplace[1], endplace[2], endplace[3]);
		
		ResultMessage result = sc.addAdjust(vo1, vo2);
		
		System.out.println(result.getKey());
		if(result.getKey().equals("success")){
			//画出data
			ui.paintdata(new AdjustDataPane((AdjustVO) result.getValue(), this));
			return true;
		}
		else{
			return false;
		}
	}
	
	public void delete(int i){
		ResultMessage result = sc.delAdjust(i);
		if(result.getKey().equals("success")){
			ui.paintdata(new AdjustDataPane((AdjustVO) result.getValue(), this));
		}
		else{
			ui.paintdata(new AdjustDataPane((AdjustVO) result.getValue(), this));
		}
	}
}
