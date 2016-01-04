package presentation.logisticsui.transitcenterclerkui.tool;

import java.awt.event.ActionListener;

import presentation.mainui.component.MyTool;

@SuppressWarnings("serial")
public class BillCheckTool extends MyTool {
	 private static String[] buttonname = {"查看到达单","查看中转单", "查看装车单", "返回"};
	 
	public BillCheckTool(ActionListener listener) {
		super(buttonname, listener);
	}

}
