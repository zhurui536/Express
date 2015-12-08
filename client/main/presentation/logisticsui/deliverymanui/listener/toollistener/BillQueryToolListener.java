package main.presentation.logisticsui.deliverymanui.listener.toollistener;

import java.awt.event.ActionEvent;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.LogisticsBLService;
import main.presentation.logisticsui.deliverymanui.BillQueryDataPane;
import main.presentation.logisticsui.deliverymanui.DeliveryManFrame;
import main.presentation.logisticsui.deliverymanui.inputframe.BillQueryInputFrame;
import main.presentation.storeui.listener.ToolListener;
import main.presentation.storeui.tool.GetButtonOfTool;
import main.vo.logisticvo.SendBillVO;

public class BillQueryToolListener extends ToolListener{
        
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
                }
        }
}
