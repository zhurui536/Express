package presentation.billui.listener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import bussinesslogicservice.billblservice.BillBLService;
import po.financepo.PayBillPO;
import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.ReceiptBillPO;
import po.logisticpo.SendBillPO;
import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import presentation.WarningDialog;
import presentation.billui.datapanel.ArrivalBillDataPane;
import presentation.billui.datapanel.BillDataPane;
import presentation.billui.datapanel.DeliveryBillDataPane;
import presentation.billui.datapanel.InStoreBillDataPane;
import presentation.billui.datapanel.LoadingBillDataPane;
import presentation.billui.datapanel.OutStoreBillDataPane;
import presentation.billui.datapanel.PayBillDataPane;
import presentation.billui.datapanel.ReceiptBillDataPane;
import presentation.billui.datapanel.SendBillDataPane;
import presentation.billui.tool.BillJudgeTool;
import presentation.mainui.component.MyTool;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import util.BillType;
import util.ResultMessage;
import vo.BillVO;

public class BillJudgeToolListener extends ToolListener {
	private BillBLService bc;
	private ManagerFrame ui;
	
	public BillJudgeToolListener(ManagerFrame ui){
		this.ui = ui;
		this.bc = ui.getBillBLController();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		MyTool tool = super.getTool();
		//为了减少警告，放到上面来
		
		for(i=0;i<tool.getNumOfButton();i++){
			if(e.getSource() == tool.getButton(i)){
				break;
			}
		}
		
		if(i==0){
			ResultMessage result = bc.approves();
			
			if(result.getKey().equals("success")){
				result = bc.getBills();
				if(result.getKey().equals("success")){
					BillDataPane data = new BillDataPane((ArrayList<BillVO>) result.getValue(), this);
					ui.paintdata(data);
				}
				else{
					if(result.getKey().equals("internet error")){
						new WarningDialog(ui, "网络连接出错！！");
					}
					if(result.getKey().equals("dataerror")){
						new WarningDialog(ui, "数据存储出错！！");
					}
					if(result.getKey().equals("noexist")){
						new WarningDialog(ui, "单据不存在！！");
					}
					if(result.getKey().equals("unknownerror")){
						new WarningDialog(ui, "未知错误");
					}
				}
			}
			else{
				new WarningDialog(ui, result);
			}
		}
		else if(i==1){
			//将窗口中的tool和datapanel移除，并将窗口返回空闲状态
			bc.end();
			ui.paintdata(null);
			ui.replaceTool(null);
		}
		else if(i==2){
			ResultMessage result = bc.getBills();
			if(result.getKey().equals("success")){
				BillDataPane data = new BillDataPane((ArrayList<BillVO>) result.getValue(), this);
				ui.paintdata(data);
			}
			else{
				new WarningDialog(ui, result);
			}
		}
		if(i==3){
			BillJudgeTool billtool = (BillJudgeTool) tool;
			ResultMessage result = bc.getBills(this.types[billtool.billType.getSelectedIndex()]);
			
			if(result.getKey().equals("success")){
				BillDataPane data = new BillDataPane((ArrayList<BillVO>) result.getValue(), this);
				ui.paintdata(data);
			}
			else{
				new WarningDialog(ui, result);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void approve(String billid, BillType type){
		ResultMessage result = bc.approve(billid, type);
		
		result = bc.getBills();
		if(result.getKey().equals("success")){
			BillDataPane data = new BillDataPane((ArrayList<BillVO>) result.getValue(), this);
			ui.paintdata(data);
		}
		else{
			new WarningDialog(ui, result);
		}
	}
	
	public void getDetail(String id, BillType type){
		ResultMessage result = bc.chooseBill(id, type);
		
		if(result.getKey().equals("success")){
			//将单据显示出来
			if(type == BillType.INSTORE){
				InStoreBillPO po = (InStoreBillPO) result.getValue();
				
				InStoreBillDataPane data = new InStoreBillDataPane(po);
				ui.paintdata(data);
			}
			else if(type == BillType.OUTSTORE){
				OutStoreBillPO po = (OutStoreBillPO) result.getValue();
				
				OutStoreBillDataPane data = new OutStoreBillDataPane(po);
				ui.paintdata(data);
			}
			else if(type == BillType.PAYMENT){
				PayBillPO po = (PayBillPO) result.getValue();
				
				PayBillDataPane data = new PayBillDataPane(po);
				ui.paintdata(data);
			}
			else if(type == BillType.RECEIPT){
				ReceiptBillPO po = (ReceiptBillPO) result.getValue();
				
				ReceiptBillDataPane data = new ReceiptBillDataPane(po);
				ui.paintdata(data);
			}
			else if(type == BillType.ARRIVAL){
				ArrivalBillPO po = (ArrivalBillPO) result.getValue();
				
				ArrivalBillDataPane data = new ArrivalBillDataPane(po);
				ui.paintdata(data);
			}
			else if(type == BillType.DELIVERY){
				DeliveryBillPO po = (DeliveryBillPO) result.getValue();
				
				DeliveryBillDataPane data= new DeliveryBillDataPane(po);
				ui.paintdata(data);
			}
			else if(type == BillType.LOADING){
				LoadingBillPO po = (LoadingBillPO) result.getValue();
				
				LoadingBillDataPane data = new LoadingBillDataPane(po);
				ui.paintdata(data);
			}
			else if(type == BillType.SEND){
				SendBillPO po = (SendBillPO) result.getValue();
				
				SendBillDataPane data = new SendBillDataPane(po);
				ui.paintdata(data);
			}
		}
		else{
			new WarningDialog(ui, result);
		}
	}

	private final BillType[] types = {
			BillType.OUTSTORE, BillType.INSTORE, BillType.PAYMENT, BillType.RECEIPT, BillType.ARRIVAL, BillType.DELIVERY,
			BillType.LOADING, BillType.SEND, BillType.TRANSIT
	};
}
