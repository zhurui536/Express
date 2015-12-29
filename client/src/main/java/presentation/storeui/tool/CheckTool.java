package presentation.storeui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class CheckTool extends MyTool{
	
	public CheckTool(ToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"查看当前库存", "出入库记录查询", "返回"};
}
