package main.presentation.storeui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.presentation.storeui.StoreFrame;
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
		
		ToolListener tl = new ToolListener(storeui); 
		
		if(i==0){
			InStoreTool tool = new InStoreTool(tl);
			tl.setTool(tool);
			storeui.setToolListener(tl);
			storeui.replaceTool(tool);
		}
		else if(i==1){
			OutStoreTool tool = new OutStoreTool(tl);
			tl.setTool(tool);
			storeui.replaceTool(tool);
			storeui.setToolListener(tl);
		}
		else if(i==2){
			CheckTool tool = new CheckTool(tl);
			storeui.replaceTool(tool);
			tl.setTool(tool);
			storeui.setToolListener(tl);
		}
		else if(i==3){
			VerificationTool tool = new VerificationTool(tl);
			storeui.replaceTool(tool);
			tl.setTool(tool);
			storeui.setToolListener(tl);
		}
		else if(i==4){
			AdjustTool tool = new AdjustTool(tl);
			storeui.replaceTool(tool);
			tl.setTool(tool);
			storeui.setToolListener(tl);
		}
		else
			storeui.close();
	}

}
