package presentation.infoui.tool;

import presentation.infoui.listener.InstitutionInfoToolListener;
import presentation.mainui.component.MyTool;

@SuppressWarnings("serial")
public class InstitutionInfoTool extends MyTool {
	public InstitutionInfoTool(InstitutionInfoToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"当前信息查看", "新增机构", "删除机构", "修改机构信息", "返回"};
}
