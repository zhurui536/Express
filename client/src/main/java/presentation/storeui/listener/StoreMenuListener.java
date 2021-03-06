package presentation.storeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bussinesslogicservice.storeblservice.StoreBLService;
import presentation.WarningDialog;
import presentation.storeui.StoreFrame;
import presentation.storeui.datapanel.VerificationDataPane;
import presentation.storeui.listener.toollistener.AdjustToolListener;
import presentation.storeui.listener.toollistener.CheckBillToolListener;
import presentation.storeui.listener.toollistener.CheckToolListener;
import presentation.storeui.listener.toollistener.InStoreToolListener;
import presentation.storeui.listener.toollistener.OutStoreToolListener;
import presentation.storeui.listener.toollistener.VerificationToolListener;
import presentation.storeui.tool.AdjustTool;
import presentation.storeui.tool.CheckBillTool;
import presentation.storeui.tool.CheckTool;
import presentation.storeui.tool.InStoreTool;
import presentation.storeui.tool.OutStoreTool;
import presentation.storeui.tool.VerificationTool;
import util.ResultMessage;
import vo.storevo.VerificationVO;

public class StoreMenuListener implements ActionListener {
	private StoreFrame storeui;
	
	public StoreMenuListener(StoreFrame ui){
		this.storeui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i=0;
		while(true){//找出事件来源
			if(e.getSource() == storeui.getButton(i)){
				break;
			}
			else{
				i++;
			}
		}
		
		StoreBLService sc = storeui.getController();
		
		if(i==0){//0为入库按钮
			ResultMessage result = sc.newInStore();
			if(result.getKey().equals("success")){
				//将该按钮变为点击后的样子
				storeui.refreshMenu();
				storeui.getButton(i).clicked();
				
				InStoreToolListener tl = new InStoreToolListener(storeui);
				InStoreTool tool = new InStoreTool(tl);
				tl.setTool(tool);
				storeui.replaceTool(tool);
			}
			if(result.getKey().equals("busy")){
				new WarningDialog(storeui, "请结束当前任务");
			}
		}
		else if(i==1){//1为出库按钮
			ResultMessage result = sc.newOutStore();
			if(result.getKey().equals("success")){
				//将该按钮变为点击后的样子
				storeui.refreshMenu();
				storeui.getButton(i).clicked();
				
				OutStoreToolListener tl = new OutStoreToolListener(storeui);
				OutStoreTool tool = new OutStoreTool(tl);
				tl.setTool(tool);
				storeui.replaceTool(tool);
			}
			if(result.getKey().equals("busy")){
				new WarningDialog(storeui, "请结束当前任务");
			}
		}
		else if(i==2){//2为库存查看
			ResultMessage result = sc.newCheck();
			if(result.getKey().equals("success")){
				//将该按钮变为点击后的样子
				storeui.refreshMenu();
				storeui.getButton(i).clicked();
				
				CheckToolListener tl = new CheckToolListener(storeui);
				CheckTool tool = new CheckTool(tl);
				storeui.replaceTool(tool);
				tl.setTool(tool);
			}
			if(result.getKey().equals("busy")){
				new WarningDialog(storeui, "请结束当前任务");
			}
		}
		else if(i==3){//3为库存盘点，在这里画data区是因为data区并不需要监听事件来改变
			ResultMessage result = sc.verification();
			if(result.getKey().equals("success")){
				//将该按钮变为点击后的样子
				storeui.refreshMenu();
				storeui.getButton(i).clicked();
				
				VerificationVO vo = (VerificationVO) result.getValue();
				
				VerificationToolListener tl = new VerificationToolListener(storeui);
				VerificationTool tool = new VerificationTool(tl);
				tool.setPihao(vo.pihao);
				storeui.replaceTool(tool);
				tl.setTool(tool);
				
				VerificationDataPane panel = new VerificationDataPane(vo);
				storeui.paintdata(panel);
				tl.setTable(panel.getTable());
			}
			if(result.getKey().equals("busy")){
				new WarningDialog(storeui, "请结束当前任务");
			}
		}
		else if(i==4){//4代表库存调整
			ResultMessage result = sc.newAdjust();
			if(result.getKey().equals("success")){
				//将该按钮变为点击后的样子
				storeui.refreshMenu();
				storeui.getButton(i).clicked();
				
				AdjustToolListener tl = new AdjustToolListener(storeui);
				AdjustTool tool = new AdjustTool(tl);
				storeui.replaceTool(tool);
				tl.setTool(tool);
			}
			if(result.getKey().equals("busy")){
				new WarningDialog(storeui, "请结束当前任务");
			}
		}
		else if(i==5){
			ResultMessage result = sc.checkInStore();
			if(result.getKey().equals("busy")){
				new WarningDialog(storeui, "请结束当前任务");
			}
			if(result.getKey().equals("success")){
				//将该按钮变为点击后的样子
				storeui.refreshMenu();
				storeui.getButton(i).clicked();
				
				CheckBillToolListener tl = new CheckBillToolListener(storeui);
				CheckBillTool tool = new CheckBillTool(tl);
				storeui.replaceTool(tool);
				tl.setTool(tool);
			}
		}
		else//最后为退出
			storeui.close();
	}

}
