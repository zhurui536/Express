package presentation.storeui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class CheckTool extends MyTool{
	
	public CheckTool(ToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"search", "返回"};
}
