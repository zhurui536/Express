package presentation.financeui.tool;

import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.toollistener.PayToolListener;
import presentation.mainui.component.MyTool;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class PayTool extends MyTool {
	
	private static String[] buttonname = { "生成付款单" };

    public PayTool(FinanceFrame ui) {
    	super(buttonname, new PayToolListener(ui));
    }
    
}
