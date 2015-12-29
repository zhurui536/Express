package presentation.financeui.tool;

import presentation.financeui.listener.toollistener.ReportToolListener;
import presentation.mainui.ExpressFrame;
import presentation.mainui.component.MyTool;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ReportTool extends MyTool {

	private static String[] buttonname = { "显示成本收益表", "导出成本收益表", "显示经营情况表", "导出经营情况表" };

    public ReportTool(ExpressFrame ui) {
    	super(buttonname, new ReportToolListener(ui));
    }

}
