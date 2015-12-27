package presentation.logisticsui.businessofficeclerkui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class GoodsLoadTool extends MyTool{
        
        public GoodsLoadTool(ToolListener toolListener) {
        	super(buttonname, toolListener);
        }
        private static String[] buttonname = {"生成装车单", "返回"};
}
