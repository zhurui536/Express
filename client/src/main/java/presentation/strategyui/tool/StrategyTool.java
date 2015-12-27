package presentation.strategyui.tool;

import presentation.mainui.component.MyTool;
import presentation.strategyui.listener.StrategyToolListener;

@SuppressWarnings("serial")
public class StrategyTool extends MyTool {
	
	private StrategyToolListener tl;
	
	public StrategyTool(StrategyToolListener tl){
		super(buttonname, tl);
	}
	
	private static String[] buttonname = {"城市距离制定", "运费制定", "运费距离查看", "返回"};
}
