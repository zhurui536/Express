package presentation.storeui.listener.toollistener;

import bussinesslogicservice.storeblservice.StoreBLService;
import presentation.WarningDialog;
import presentation.mainui.component.MyTool;
import presentation.storeui.StoreFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;

import javax.swing.*;

import java.awt.event.ActionEvent;

public class VerificationToolListener extends ToolListener {

	private StoreBLService sc;
	private StoreFrame ui;
	private JTable table;
	
	public VerificationToolListener(StoreFrame ui) {
		this.ui = ui;
		this.sc = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyTool tool = super.getTool();
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
				WarningDialog frame;
				if(result.getKey().equals("internet error")){
					frame = new WarningDialog(ui, "网络连接出错！！");
				}
				if(result.getKey().equals("dataerror")){
					frame = new WarningDialog(ui, "数据存储出错！！");
				}
			}
		}
		else if(i==1){
			sc.endVerification(1);
			ui.replaceTool(null);
			ui.paintdata(null);
		}
		else if(i==2){
			ResultMessage result = sc.exportVerification(table);
			WarningDialog frame;
			if(result.getKey().equals("success")){
				frame = new WarningDialog(ui, "导出成功");
			}
			else{
				frame = new WarningDialog(ui, "导出失败");
			}
		}
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
