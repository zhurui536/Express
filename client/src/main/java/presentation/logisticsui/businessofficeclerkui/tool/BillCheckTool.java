package presentation.logisticsui.businessofficeclerkui.tool;

import java.awt.event.ActionListener;

import presentation.mainui.component.MyTool;

@SuppressWarnings("serial")
public class BillCheckTool extends MyTool {
	private static final String[] NAMES = {"查看装车单","查看到达单", "查看派件单", "查看收款单"};
	
	public BillCheckTool(ActionListener listener) {
		super(NAMES, listener);
	}

}
