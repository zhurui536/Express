package presentation.financeui.tool;

import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.toollistener.BankAccountManagementToolListener;
import presentation.mainui.component.MyTool;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountManagementTool extends MyTool {

    private static String[] buttonname = {"新增账户", "删除账户", "查询账户", "修改账户" };
    
    public BankAccountManagementTool(FinanceFrame ui) {
    	super(buttonname, new BankAccountManagementToolListener(ui));
    }
}
