package presentation.storeui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class OutStoreTool extends MyTool{
	
	public OutStoreTool(ToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"新建出库项", "确定", "取消出库"};
}
