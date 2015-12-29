package presentation.storeui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class CheckBillTool extends MyTool {
	
	public CheckBillTool(ToolListener tl){
		super(buttons, tl);
	}
	
	private static String[] buttons = {"查看入库单", "查看出库单", "返回"};
}
