package presentation.storeui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

public class CheckBillTool extends MyTool {
	
	public CheckBillTool(ToolListener tl){
		super(buttons, tl);
	}
	
	private static String[] buttons = {"查看入库单", "查看入库单", "查看当前库存", "返回"};
}
