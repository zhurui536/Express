package presentation.storeui.listener.toollistener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import bussinesslogicservice.storeblservice.StoreBLService;
import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import presentation.WarningDialog;
import presentation.billui.datapanel.BillListPane;
import presentation.mainui.component.MyTool;
import presentation.storeui.StoreFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;

public class CheckBillToolListener extends ToolListener {
	private StoreBLService sc;
	private StoreFrame ui;
	
	public CheckBillToolListener(StoreFrame ui){
		this.ui = ui;
		this.sc = ui.getController();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		MyTool tool = super.getTool();
		
		for(i=0;i<tool.getNumOfButton();i++){
			if(e.getSource() == tool.getButton(i))
				break;
		}
		
		if(i==0){
			ResultMessage result = sc.checkInStore();
			if(result.getKey().equals("success")){
				ArrayList<InStoreBillPO> bills = (ArrayList<InStoreBillPO>) result.getValue();
				BillListPane data = new BillListPane(bills);
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
			ResultMessage result = sc.checkOutStore();
			if(result.getKey().equals("success")){
				ArrayList<OutStoreBillPO> bills = (ArrayList<OutStoreBillPO>) result.getValue();
				BillListPane data = new BillListPane(bills);
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
//		if(i==2){
//			ResultMessage result = sc.checkStore();
//			if(result.getKey().equals("success")){
//				StorePO store = (StorePO) result.getValue();
//				StoreDataPane data = new StoreDataPane(store);
//				ui.paintdata(data);
//			}
//			else{
//				WarningDialog tip = new WarningDialog(ui, result.getKey());
//			}
//		}
		if(i==2){
			ui.replaceTool(null);
			ui.paintdata(null);
		}
	}
}
