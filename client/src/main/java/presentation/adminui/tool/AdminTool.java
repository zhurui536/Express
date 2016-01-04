package presentation.adminui.tool;

import presentation.adminui.listener.AdminToolListener;
import presentation.mainui.component.MyTool;

@SuppressWarnings("serial")
public class AdminTool extends MyTool {
	
	public AdminTool(AdminToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"新建用户", "取消", "确定"};
}
