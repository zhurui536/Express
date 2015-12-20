package presentation.logisticsui.businessofficeclerkui.tool;

import javax.swing.JButton;

import presentation.ToolPane;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class TruckMessageTool extends ToolPane{
        private static final int NUMBER_OF_BUTTIONS = 5;
        
        private static final String[] NAMES = {"新增车辆信息","查看车辆信息","删除车辆信息","修改车辆信息"};

        public TruckMessageTool(ToolListener toolListener) {
                super.buttons = new JButton[NUMBER_OF_BUTTIONS];
                
                for (int i = 0; i < NUMBER_OF_BUTTIONS - 1; i++) {
                        buttons[i] = new JButton(NAMES[i]);
                        buttons[i].setSize(125, 25);
                        buttons[i].setLocation(145 + i * 150, 40);
                        buttons[i].addActionListener(toolListener);
                        this.add(buttons[i]);
                }

                buttons[NUMBER_OF_BUTTIONS - 1] = new JButton("返回");
                buttons[NUMBER_OF_BUTTIONS - 1].setSize(100, 30);
                buttons[NUMBER_OF_BUTTIONS - 1].setLocation(880, 35);
                buttons[NUMBER_OF_BUTTIONS - 1].addActionListener(toolListener);
                this.add(buttons[NUMBER_OF_BUTTIONS - 1]);
        }
}
