package main.presentation.logisticsui.transitcenterclerkui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;

public class MenuListener implements ActionListener{

        TransitCenterclerkFrame ui;
        
        public MenuListener(TransitCenterclerkFrame ui) {
                super();
                this.ui = ui;
        }



        @Override
        public void actionPerformed(ActionEvent e) {
                int i=0;
                while (true) {// 找出事件来源
                        if (e.getSource() == ui.getButton(i)) {
                                break;
                        } else {
                                i++;
                        }
                }
        }

}
