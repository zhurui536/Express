package presentation.logisticsui.transitcenterclerkui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class GoodsRecTool extends MyTool{
        
//        private static final int NUMBER_OF_BUTTIONS = 2;
        
        
        public GoodsRecTool(ToolListener toolListener) {
        	super(buttonname, toolListener);
//        		super.buttons = new JButton[NUMBER_OF_BUTTIONS];
//
//                this.setName("goodsReceipt");
//                this.setLayout(null);
//                this.setSize(1000, 100);
//                this.setLocation(0, 0);
//                
//                buttons[0] = new JButton("生成到达单");
//                buttons[0].setSize(125, 25);
//                buttons[0].setLocation(145, 40);
//                buttons[0].addActionListener(toolListener);
//                this.add(buttons[0]);
//                
//                buttons[1] = new JButton("返回");
//                buttons[1].setSize(100, 30);
//                buttons[1].setLocation(880, 35);
//                buttons[1].addActionListener(toolListener);
//                this.add(buttons[1]);
        }
        private static String[] buttonname = {"生成到达单", "返回"};
}
