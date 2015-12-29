package presentation.infoui.tool;

import presentation.infoui.listener.StaffInfoToolListener;
import presentation.mainui.component.MyTool;

@SuppressWarnings("serial")
public class StaffInfoTool extends MyTool {
	
	public StaffInfoTool(StaffInfoToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"当前信息查看", "新增员工", "删除员工", "修改员工信息", "返回"};
}
