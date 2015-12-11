package presentation.strategyui;

import java.awt.event.ActionEvent;

import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;

public class StrategyToolListener extends ToolListener {
	private ManagerFrame ui;
	
	public StrategyToolListener(ManagerFrame ui){
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}
