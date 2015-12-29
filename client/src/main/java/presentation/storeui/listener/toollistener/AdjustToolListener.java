package presentation.storeui.listener.toollistener;

import bussinesslogicservice.storeblservice.StoreBLService;
import presentation.WarningDialog;
import presentation.mainui.component.MyTool;
import presentation.storeui.StoreFrame;
import presentation.storeui.datapanel.AdjustDataPane;
import presentation.storeui.inputframe.AdjustInputFrame;
import presentation.storeui.listener.ToolListener;
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
		MyTool tool = super.getTool();
		
		for(i=0;i<tool.getNumOfButton();i++){
			if(arg0.getSource() == tool.getButton(i))
				break;
		}
		
		if(i==0){
			AdjustInputFrame adjust = new AdjustInputFrame(this);
			adjust.setVisible(true);
		}
		else if(i==1){//确认进行调整
			ResultMessage result = sc.endAdjust(0);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				WarningDialog frame;
				if(result.getKey().equals("internet error")){
					frame = new WarningDialog(ui, "网络连接出错！！");
				}
				if(result.getKey().equals("dataerror")){
					frame = new WarningDialog(ui, "数据存储出错！！");
				}
			}
		}
		else if(i==2){//取消调整必定成功
			ResultMessage result = sc.endAdjust(1);
			if(result.getKey().equals("success")){
				ui.replaceTool(null);
				ui.paintdata(null);
			}
			else{
				//提示错误
				WarningDialog frame = new WarningDialog(ui, result);
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
			WarningDialog frame;
			if(result.getKey().equals("appearedplace")){
				frame = new WarningDialog(ui, "不能多次输入同个位置！");
			}
			if(result.getKey().equals("emptystart")){
				frame = new WarningDialog(ui, "起始位置是空的！");
			}
			if(result.getKey().equals("usedend")){
				frame = new WarningDialog(ui, "目标位置已有货物！");
			}
			if(result.getKey().equals("internet error")){
				frame = new WarningDialog(ui, "网络连接出错！！");
			}
			if(result.getKey().equals("dataerror")){
				frame = new WarningDialog(ui, "数据存储出错！！");
			}
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
