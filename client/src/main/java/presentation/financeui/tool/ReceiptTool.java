package presentation.financeui.tool;

import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.toollistener.ReceiptToolListener;
import presentation.mainui.component.MyTool;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ReceiptTool extends MyTool {

	private static String[] buttonname = { "显示收款单" };

    public ReceiptTool(FinanceFrame ui) {
    	super(buttonname, new ReceiptToolListener(ui));
    }

}
