package presentation.logisticsui.businessofficeclerkui.listerner.toollistener;

import java.awt.event.ActionEvent;

import presentation.WarningDialog;
import presentation.mainui.component.MyTool;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.inputframe.GoodsDelivInputFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;

public class GoodsDelivToolListener extends ToolListener{
        private LogisticsBLService logisticsBLService;
        private BusinessOfficeClerkFrame ui;
        
        public GoodsDelivToolListener(BusinessOfficeClerkFrame ui) {
                super();
                this.ui = ui;
                this.logisticsBLService = ui.getLogisticsBLService();
        }
        
        public boolean getInput(String id){
                ResultMessage resultMessage = logisticsBLService.produceDeliveryBill(id);
                if(resultMessage.getKey().equals("SUCCESS")){
                        ui.paintdata(null);
                        return true;
                }else {
                        new WarningDialog(ui, resultMessage);
                        return false;
                }
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	MyTool tool = super.getTool();
                if(e.getSource() == tool.getButton(0)){
                        GoodsDelivInputFrame frame = new GoodsDelivInputFrame(this);
                        frame.setVisible(true);
                }else{
                        logisticsBLService.endReceipt();
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
}
