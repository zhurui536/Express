package presentation.logisticsui.deliverymanui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class BillQueryTool extends MyTool{

//        private static final int NUMBER_OF_BUTTIONS = 2;
        
        public BillQueryTool(ToolListener toolListener){
        	super(buttonname, toolListener);
//                super.buttons = new JButton[NUMBER_OF_BUTTIONS];
//                
//                buttons[0] = new JButton("输入订单号");
//                buttons[0].setSize(105, 25);
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
        
        private static String[] buttonname = {"输入订单号", "返回"};
}
