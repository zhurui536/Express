package presentation.logisticsui.deliverymanui.tool;

import javax.swing.JButton;

import presentation.ToolPane;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class DeliveryTool extends ToolPane{

        private static final int NUMBER_OF_BUTTIONS = 2;
        
        public DeliveryTool(ToolListener toolListener) {
                super.buttons = new JButton[NUMBER_OF_BUTTIONS];
                
                buttons[0] = new JButton("输入收件信息");
                buttons[0].setSize(105, 25);
                buttons[0].setLocation(145, 40);
                buttons[0].addActionListener(toolListener);
                this.add(buttons[0]);
                
                buttons[1] = new JButton("返回");
                buttons[1].setSize(100, 30);
                buttons[1].setLocation(880, 35);
                buttons[1].addActionListener(toolListener);
                this.add(buttons[1]);
        }
}
