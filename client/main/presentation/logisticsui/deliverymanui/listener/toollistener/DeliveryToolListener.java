package main.presentation.logisticsui.deliverymanui.listener.toollistener;

import java.awt.event.ActionEvent;


import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.logisticsblservice.LogisticsBLService;
import main.presentation.logisticsui.deliverymanui.DeliveryManFrame;
import main.presentation.logisticsui.deliverymanui.inputframe.DeliveryInputFrame;
import main.presentation.storeui.listener.ToolListener;
import main.presentation.storeui.tool.GetButtonOfTool;

public class DeliveryToolListener extends ToolListener{
        
        private LogisticsBLService logisticsBLService;
        private DeliveryManFrame ui;
        
        public DeliveryToolListener(DeliveryManFrame ui) {
                this.ui = ui;
                this.logisticsBLService = ui.getController();
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                int i;
                GetButtonOfTool tool = super.getTool();

                for (i = 0; i < tool.getNumOfButton(); i++) {
                        if (e.getSource() == tool.getButton(i))
                                break;
                }
                if(i == 0){
                        DeliveryInputFrame frame = new DeliveryInputFrame(this);
                        frame.setVisible(true);
                }else{
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
        
        public boolean getInput(String Recipients, String id, Time time) {
                ResultMessage resultMessage = logisticsBLService.addRecMessage(Recipients, id, time);
                if(resultMessage.getKey().equals("SUCCESS")){
                        ui.paintdata(null);
                        return true;
                }else{
                        return false;
                }
        }

}
