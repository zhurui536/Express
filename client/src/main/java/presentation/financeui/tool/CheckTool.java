package presentation.financeui.tool;

import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.toollistener.CheckToolListener;
import presentation.mainui.component.MyTool;

@SuppressWarnings("serial")
public class CheckTool extends MyTool {
	
	private static String[] buttonname = { "付款单" };
    
    public CheckTool(FinanceFrame ui) {
    	super(buttonname, new CheckToolListener(ui));
    }
}
