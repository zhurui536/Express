package presentation.strategyui.tool;

import presentation.mainui.component.MyTool;
import presentation.strategyui.listener.SalaryToolListener;

public class SalaryTool extends MyTool {
	
	public SalaryTool(SalaryToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"当前薪水查看", "确定", "返回"};
}
