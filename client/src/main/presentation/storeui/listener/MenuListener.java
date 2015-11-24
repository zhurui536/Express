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
		
		if(i==0)
			storeui.replaceTool(new InStoreTool());
		else if(i==1)
			storeui.replaceTool(new OutStoreTool());
		else if(i==2)
			storeui.replaceTool(new CheckTool());
		else if(i==3)
			storeui.replaceTool(new VerificationTool());
		else if(i==4)
			storeui.replaceTool(new AdjustTool());
		else
			storeui.close();
	}

}
