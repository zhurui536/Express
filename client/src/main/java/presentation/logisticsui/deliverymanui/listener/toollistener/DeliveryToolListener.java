package presentation.logisticsui.deliverymanui.listener.toollistener;

import java.awt.event.ActionEvent;

import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.logisticsui.deliverymanui.DeliveryManFrame;
import presentation.logisticsui.deliverymanui.inputframe.DeliveryInputFrame;
import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import util.Time;

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
                MyTool tool = super.getTool();

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
