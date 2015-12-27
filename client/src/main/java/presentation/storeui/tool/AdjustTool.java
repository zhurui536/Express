package presentation.storeui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class AdjustTool extends MyTool{
	
	public AdjustTool(ToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"新建移动项", "确定", "取消调整"};
}
