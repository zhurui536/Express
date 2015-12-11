package presentation.logisticsui.transitcenterclerkui.tool;

import javax.swing.JButton;

import presentation.ToolPane;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class GoodsTranTool extends ToolPane{

        private static final int NUMBER_OF_BUTTIONS = 4;
        
       
        
        private final String[] transTypeName = {"火车装运","汽车装运","飞机装运"};

        public GoodsTranTool(ToolListener toolListener) {
        		super.buttons = new JButton[NUMBER_OF_BUTTIONS];
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

}
