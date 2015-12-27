package presentation.financeui.tool;

import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.toollistener.InitToolListener;
import presentation.mainui.component.MyTool;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class InitTool extends MyTool {
	
	private static String[] buttonname = { "新建账本", "查询" };

    public InitTool(FinanceFrame ui) {
    	super(buttonname, new InitToolListener(ui));
    }

}
