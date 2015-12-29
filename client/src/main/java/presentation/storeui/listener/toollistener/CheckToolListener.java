package presentation.storeui.listener.toollistener;

import bussinesslogicservice.storeblservice.StoreBLService;
import po.storepo.StorePO;
import presentation.WarningDialog;
import presentation.mainui.component.MyTool;
import presentation.storeui.StoreFrame;
import presentation.storeui.datapanel.CheckDataPane;
import presentation.storeui.datapanel.StoreDataPane;
import presentation.storeui.inputframe.CheckInputFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.storevo.CheckVO;

import java.awt.event.ActionEvent;
import java.util.Calendar;

public class CheckToolListener extends ToolListener {

	private StoreBLService sc;
	private StoreFrame ui;
	
	public CheckToolListener(StoreFrame ui) {
		this.ui = ui;
		this.sc = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyTool tool = super.getTool();
		int i;
		
		for(i=0;i<tool.getNumOfButton();i++){
			if(e.getSource() == tool.getButton(i))
				break;
		}
		
		if(i==0){
			ResultMessage result = sc.checkStore();
			if(result.getKey().equals("success")){
				StorePO store = (StorePO) result.getValue();
				StoreDataPane data = new StoreDataPane(store);
				ui.paintdata(data);
			}
			else{
				if(result.getKey().equals("internet error")){
					new WarningDialog(ui, "网络连接出错！！");
				}
				if(result.getKey().equals("dataerror")){
					new WarningDialog(ui, "数据存储出错！！");
				}
			}
		}
		if(i==1){
			CheckInputFrame frame = new CheckInputFrame(this);
			frame.setVisible(true);
		}
		if(i==2){
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
			if(result.getKey().equals("internet error")){
				new WarningDialog(ui, "网络连接出错！！");
			}
			if(result.getKey().equals("dataerror")){
				new WarningDialog(ui, "数据存储出错！！");
			}
			return false;
		}
	}

}
