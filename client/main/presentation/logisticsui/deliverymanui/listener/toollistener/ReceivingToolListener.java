package main.presentation.logisticsui.deliverymanui.listener.toollistener;

import java.awt.event.ActionEvent;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.LogisticsBLService;
import main.presentation.logisticsui.deliverymanui.DeliveryManFrame;
import main.presentation.logisticsui.deliverymanui.datapane.ReceivingDataPane;
import main.presentation.logisticsui.deliverymanui.inputframe.ReceivingInputFrame;
import main.presentation.storeui.listener.ToolListener;
import main.presentation.storeui.tool.GetButtonOfTool;
import main.vo.logisticvo.SendBillVO;

public class ReceivingToolListener extends ToolListener{
        
        private LogisticsBLService logisticsBLService;
        private DeliveryManFrame ui;
        
        public ReceivingToolListener(DeliveryManFrame ui) {
                this.ui = ui;
                this.logisticsBLService = ui.getController();
        }

        public boolean getInput(SendBillVO sendBillVO) {
                ResultMessage resultMessage = logisticsBLService.addMessage(sendBillVO);
                long time = logisticsBLService.getTime(sendBillVO.goodsVO.departurePlace, sendBillVO.goodsVO.destination);
                if(resultMessage.getKey().equals("SUCCESS")){
                        ui.paintdata(new ReceivingDataPane((SendBillVO) resultMessage.getValue(), time));
                        return true;
                }else{
                        return false;
                }
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                GetButtonOfTool tool = super.getTool();
                if(e.getSource() == tool.getButton(0)){
                        ReceivingInputFrame frame = new ReceivingInputFrame(this);
                        frame.setVisible(true);
                }else{
                        logisticsBLService.endReceipt();
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
}
