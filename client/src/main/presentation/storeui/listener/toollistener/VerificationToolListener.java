package main.presentation.storeui.listener.toollistener;

import java.awt.event.ActionEvent;

import main.bussinesslogic.storebl.StoreBLController;
import main.presentation.storeui.StoreFrame;
import main.presentation.storeui.listener.ToolListener;

public class VerificationToolListener extends ToolListener {

	private StoreBLController sc;
	
	public VerificationToolListener(StoreFrame ui) {
		this.sc = ui.getController();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
