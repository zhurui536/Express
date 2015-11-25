package main.presentation.storeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.presentation.storeui.StoreFrame;
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

public class MenuListener implements ActionListener {
	private StoreFrame storeui;
	
	public MenuListener(StoreFrame ui){
		this.storeui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int i=0;
		while(true){
			if(e.getSource() == storeui.getButton(i)){
				break;
			}
			else{
				i++;
			}
		}
		
		if(i==0){
			InStoreToolListener tl = new InStoreToolListener(storeui);
			InStoreTool tool = new InStoreTool(tl);
			tl.setTool(tool);
			storeui.replaceTool(tool);
		}
		else if(i==1){
			OutStoreToolListener tl = new OutStoreToolListener(storeui);
			OutStoreTool tool = new OutStoreTool(tl);
			tl.setTool(tool);
			storeui.replaceTool(tool);
		}
		else if(i==2){
			CheckToolListener tl = new CheckToolListener(storeui);
			CheckTool tool = new CheckTool(tl);
			storeui.replaceTool(tool);
			tl.setTool(tool);
		}
		else if(i==3){
			VerificationToolListener tl = new VerificationToolListener(storeui);
			VerificationTool tool = new VerificationTool(tl);
			storeui.replaceTool(tool);
			tl.setTool(tool);
		}
		else if(i==4){
			AdjustToolListener tl = new AdjustToolListener(storeui);
			AdjustTool tool = new AdjustTool(tl);
			storeui.replaceTool(tool);
			tl.setTool(tool);
		}
		else
			storeui.close();
	}

}
