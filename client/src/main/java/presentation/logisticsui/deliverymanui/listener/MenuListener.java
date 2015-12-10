package presentation.logisticsui.deliverymanui.listener;

import presentation.logisticsui.deliverymanui.DeliveryManFrame;
import presentation.logisticsui.deliverymanui.listener.toollistener.BillQueryToolListener;
import presentation.logisticsui.deliverymanui.listener.toollistener.DeliveryToolListener;
import presentation.logisticsui.deliverymanui.listener.toollistener.ReceivingToolListener;
import presentation.logisticsui.deliverymanui.tool.BillQueryTool;
import presentation.logisticsui.deliverymanui.tool.DeliveryTool;
import presentation.logisticsui.deliverymanui.tool.ReceivingTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                if(i == 0){
                        ReceivingToolListener receivingToolListener = new ReceivingToolListener(ui);
                        ReceivingTool tool = new ReceivingTool(receivingToolListener);
                        receivingToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if (i == 1){
                        DeliveryToolListener deliveryToolListener = new DeliveryToolListener(ui);
                        DeliveryTool tool = new DeliveryTool(deliveryToolListener);
                        deliveryToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 2){
                        BillQueryToolListener billQueryToolListener = new BillQueryToolListener(ui);
                        BillQueryTool tool = new BillQueryTool(billQueryToolListener);
                        billQueryToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }
        }

}
