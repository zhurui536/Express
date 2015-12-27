package presentation.storeui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class InStoreTool extends MyTool{
	
	public InStoreTool(ToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"新建入库项", "确定", "取消入库"};
}
