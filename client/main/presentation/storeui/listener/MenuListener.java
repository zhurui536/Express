package main.presentation.storeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.bussinesslogic.storebl.StoreBLController;
import main.bussinesslogic.util.ResultMessage;
import main.presentation.storeui.StoreFrame;
import main.presentation.storeui.datapanel.VerificationDataPane;
import main.presentation.storeui.listener.toollistener.AdjustToolListener;
import main.presentation.storeui.listener.toollistener.CheckToolListener;
import main.presentation.storeui.listener.toollistener.InStoreToolListener;
import main.presentation.storeui.listener.toollistener.OutStoreToolListener;
import main.presentation.storeui.listener.toollistener.VerificationToolListener;
import main.presentation.storeui.tool.AdjustTool;
import main.presentation.storeui.tool.CheckTool;
import main.presentation.storeui.tool.InStoreTool;
import main.presentation.storeui.tool.OutStoreTool;
import main.presentation.storeui.tool.VerificationTool;
import main.vo.storevo.VerificationVO;

public class MenuListener implements ActionListener {
	private StoreFrame storeui;
	
	public MenuListener(StoreFrame ui){
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
		
		StoreBLController sc = storeui.getController();
		
		if(i==0){//0为入库按钮
			ResultMessage result = sc.newInStore();
			if(result.getKey().equals("success")){
				InStoreToolListener tl = new InStoreToolListener(storeui);
				InStoreTool tool = new InStoreTool(tl);
				tl.setTool(tool);
				storeui.replaceTool(tool);
			}
			if(result.getKey().equals("busy")){
				System.out.println("busy");
			}
		}
		else if(i==1){//1为出库按钮
			ResultMessage result = sc.newOutStore();
			if(result.getKey().equals("success")){
				OutStoreToolListener tl = new OutStoreToolListener(storeui);
				OutStoreTool tool = new OutStoreTool(tl);
				tl.setTool(tool);
				storeui.replaceTool(tool);
			}
			if(result.getKey().equals("busy")){
				System.out.println("busy");
			}
		}
		else if(i==2){//2为库存查看
			ResultMessage result = sc.newCheck();
			if(result.getKey().equals("success")){
				CheckToolListener tl = new CheckToolListener(storeui);
				CheckTool tool = new CheckTool(tl);
				storeui.replaceTool(tool);
				tl.setTool(tool);
			}
			if(result.getKey().equals("busy")){
				System.out.println("busy");
			}
		}
		else if(i==3){//3为库存盘点，在这里画data区是因为data区并不需要监听事件来改变
			ResultMessage result = sc.verification();
			if(result.getKey().equals("success")){
				VerificationToolListener tl = new VerificationToolListener(storeui);
				VerificationTool tool = new VerificationTool(tl);
				storeui.replaceTool(tool);
				tl.setTool(tool);
				
				VerificationVO vo = (VerificationVO) result.getValue();
				VerificationDataPane panel = new VerificationDataPane(vo);
				storeui.paintdata(panel);
			}
			if(result.getKey().equals("busy")){
				System.out.println("busy");
			}
		}
		else if(i==4){//4代表库存调整
			ResultMessage result = sc.newAdjust();
			if(result.getKey().equals("success")){
				AdjustToolListener tl = new AdjustToolListener(storeui);
				AdjustTool tool = new AdjustTool(tl);
				storeui.replaceTool(tool);
				tl.setTool(tool);
			}
			if(result.getKey().equals("busy")){
				System.out.println("busy");
			}
		}
		else//最后为退出
			storeui.close();
	}

}
