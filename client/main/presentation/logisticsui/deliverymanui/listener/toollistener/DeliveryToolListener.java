package main.presentation.logisticsui.deliverymanui.listener.toollistener;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.logisticsblservice.LogisticsBLService;
import main.presentation.logisticsui.deliverymanui.DeliveryManFrame;
import main.presentation.storeui.listener.ToolListener;

public class DeliveryToolListener extends ToolListener{
        
        private LogisticsBLService logisticsBLService;
        private DeliveryManFrame ui;
        
        public DeliveryToolListener(DeliveryManFrame ui) {
                this.ui = ui;
                this.logisticsBLService = ui.getController();
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
