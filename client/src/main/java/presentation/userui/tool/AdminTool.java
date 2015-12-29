package presentation.userui.tool;

import presentation.mainui.component.MyTool;
import presentation.userui.listener.AdminToolListener;

@SuppressWarnings("serial")
public class AdminTool extends MyTool {
	
	public AdminTool(AdminToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"新建用户", "取消", "确定"};
}
