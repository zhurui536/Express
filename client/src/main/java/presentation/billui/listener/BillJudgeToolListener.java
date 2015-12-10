package presentation.billui.listener;

import bussinesslogicservice.billblservice.BillBLService;
import presentation.billui.datapanel.BillDataPane;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import presentation.storeui.tool.GetButtonOfTool;
import util.BillType;
import util.ResultMessage;
import vo.BillVO;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
				if(result.getKey().endsWith("success")){
					BillDataPane data = new BillDataPane((ArrayList<BillVO>) result.getValue(), this);
					ui.paintdata(data);
				}
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
	}
	
	public void getDetail(String billid, BillType type){
		ResultMessage result = bc.chooseBill(billid, type);
		
		if(result.getKey().equals("success")){
			//将单据显示出来
		}
	}

}