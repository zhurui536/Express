package main.presentation.logisticsui.deliverymanui.tool;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.presentation.storeui.listener.ToolListener;
import main.presentation.storeui.tool.GetButtonOfTool;

@SuppressWarnings("serial")
public class ReceivingTool extends JPanel implements GetButtonOfTool{

        private static final int NUMBER_OF_BUTTIONS = 2;
        
        private JButton[] buttons = new JButton[NUMBER_OF_BUTTIONS];
        
        public ReceivingTool(ToolListener toolListener) {
                this.setName("receiving");
                this.setLayout(null);
                this.setSize(1000, 100);
                this.setLocation(0, 0);
                
                buttons[0] = new JButton("输入订单信息");
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
        
        @Override
        public JButton getButton(int i) {
                return buttons[i];
        }

        @Override
        public int getNumOfButton() {
                return NUMBER_OF_BUTTIONS;
        }

}