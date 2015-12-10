package presentation.logisticsui.deliverymanui.listener.toollistener;


import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.logisticsui.deliverymanui.DeliveryManFrame;
import presentation.logisticsui.deliverymanui.datapane.BillQueryDataPane;
import presentation.logisticsui.deliverymanui.inputframe.BillQueryInputFrame;
import presentation.storeui.listener.ToolListener;
import presentation.storeui.tool.GetButtonOfTool;
import util.ResultMessage;
import vo.logisticvo.SendBillVO;

import java.awt.event.ActionEvent;

public class BillQueryToolListener extends ToolListener {
        
        private LogisticsBLService logisticsBLService;
        private DeliveryManFrame ui;
        
        public BillQueryToolListener(DeliveryManFrame ui) {
                this.ui = ui;
                this.logisticsBLService = ui.getController();
        }
        
        public boolean getInput(String ID) {
                ResultMessage resultMessage = logisticsBLService.queryBill(ID);
                if(resultMessage.getKey().equals("SUCCESS")){
                        ui.paintdata(new BillQueryDataPane((SendBillVO) resultMessage.getValue()));
                        return true;
                }else{
                        return false;
                }
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
                        BillQueryInputFrame frame = new BillQueryInputFrame(this);
                        frame.setVisible(true);
                }else{
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
}
