package main.presentation.logisticsui.transitcenterclerkui.tool;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.presentation.storeui.listener.ToolListener;
import main.presentation.storeui.tool.GetButtonOfTool;

@SuppressWarnings("serial")
public class GoodsTranTool extends JPanel implements GetButtonOfTool{

        private static final int NUMBER_OF_BUTTIONS = 4;
        
        private JButton[] buttons = new JButton[NUMBER_OF_BUTTIONS];
        
        private final String[] transTypeName = {"火车装运","汽车装运","飞机装运"};

        public GoodsTranTool(ToolListener toolListener) {
                this.setName("goodsTran");
                this.setLayout(null);
                this.setSize(1000, 100);
                this.setLocation(0, 0);
                
                for (int i = 0; i < 3; i++) {
                        buttons[i] = new JButton(transTypeName[i]);
                        buttons[i].setSize(125,25);
                        buttons[i].setLocation(145 + 175 * i, 40);
                        buttons[i].addActionListener(toolListener);
                        this.add(buttons[i]);
                }
                
                buttons[3] = new JButton("返回");
                buttons[3].setSize(100, 30);
                buttons[3].setLocation(880, 35);
                buttons[3].addActionListener(toolListener);
                this.add(buttons[3]);
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
