package presentation.logisticsui.businessofficeclerkui.tool;

import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class DriverMessageTool extends MyTool{
        
//        private static final int NUMBER_OF_BUTTIONS = 5;
        
        private static final String[] NAMES = {"新增司机信息","查看司机信息","删除司机信息","修改司机信息"};
        
        public DriverMessageTool(ToolListener tl) {
        	super(NAMES, tl);
//                super.buttons = new JButton[NUMBER_OF_BUTTIONS];
//        
//                for (int i = 0; i < NUMBER_OF_BUTTIONS - 1; i++) {
//                        buttons[i] = new JButton(NAMES[i]);
//                        buttons[i].setSize(125, 25);
//                        buttons[i].setLocation(145 + i * 150, 40);
//                        buttons[i].addActionListener(toolListener);
//                        this.add(buttons[i]);
//                }
//
//                buttons[NUMBER_OF_BUTTIONS - 1] = new JButton("返回");
//                buttons[NUMBER_OF_BUTTIONS - 1].setSize(100, 30);
//                buttons[NUMBER_OF_BUTTIONS - 1].setLocation(880, 35);
//                buttons[NUMBER_OF_BUTTIONS - 1].addActionListener(toolListener);
//                this.add(buttons[NUMBER_OF_BUTTIONS - 1]);
        }
}
