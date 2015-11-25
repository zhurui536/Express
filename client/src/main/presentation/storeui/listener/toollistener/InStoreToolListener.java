package main.presentation.storeui.listener.toollistener;

import java.awt.event.ActionEvent;

import main.bussinesslogic.storebl.StoreBLController;
import main.presentation.storeui.InStoreInputFrame;
import main.presentation.storeui.StoreFrame;
import main.presentation.storeui.listener.ToolListener;
import main.presentation.storeui.tool.GetButtonOfTool;

public class InStoreToolListener extends ToolListener {

	private StoreBLController sc;
	
	public InStoreToolListener(StoreFrame ui){
		this.sc = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int i;
		GetButtonOfTool tool = super.getTool();
		
		for(i=0;i<4;i++){
			if(e.getSource() == tool.getButton(i))
				break;
		}
		
		if(i==0){
			InStoreInputFrame frame = new InStoreInputFrame();
			frame.setVisible(true);
		}
		else if(i==1){
			
		}
		else if(i==2){
			
		}
		else if(i==3){
			
		}
	}

}
