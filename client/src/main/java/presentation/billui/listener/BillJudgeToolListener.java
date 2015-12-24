package presentation.billui.listener;

import bussinesslogicservice.billblservice.BillBLService;
import po.logisticpo.*;
import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import presentation.WarningDialog;
import presentation.billui.datapanel.*;
import presentation.mainui.ToolPane;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import util.BillType;
import util.ResultMessage;
import vo.BillVO;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

//import presentation.billui.datapanel.PayBillDataPane;

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
		ToolPane tool = super.getTool();
		
		for(i=0;i<tool.getNumOfButton();i++){
			if(e.getSource() == tool.getButton(i)){
				break;
			}
		}
		
		if(i==0){
			ResultMessage result = bc.approves();
			if(result.getKey().equals("success")){
				result = bc.getBills();
				if(result.getKey().endsWith("success")){
					BillDataPane data = new BillDataPane((ArrayList<BillVO>) result.getValue(), this);
					ui.paintdata(data);
				}
				else{
					WarningDialog frame = new WarningDialog(ui, result);
				}
			}
			else{
				WarningDialog frame = new WarningDialog(ui, result);
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
				WarningDialog frame = new WarningDialog(ui, result);
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
			WarningDialog frame = new WarningDialog(ui, result);
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
//				PayBillPO po = (PayBillPO) result.getValue();
//				
//				PayBillDataPane data = new PayBillDataPane(po);
//				ui.paintdata(data);
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
			WarningDialog frame = new WarningDialog(ui, result);
		}
	}

}
