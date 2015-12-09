package main.presentation.logisticsui.deliverymanui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.presentation.logisticsui.deliverymanui.DeliveryManFrame;
import main.presentation.logisticsui.deliverymanui.listener.toollistener.BillQueryToolListener;
import main.presentation.logisticsui.deliverymanui.tool.BillQueryTool;

public class MenuListener implements ActionListener{
        
        private DeliveryManFrame ui;
        
        public MenuListener(DeliveryManFrame ui) {
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
                
                if(i == 2){
                        BillQueryToolListener billQueryToolListener = new BillQueryToolListener(ui);
                        BillQueryTool tool = new BillQueryTool(billQueryToolListener);
                        billQueryToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }
        }

}
