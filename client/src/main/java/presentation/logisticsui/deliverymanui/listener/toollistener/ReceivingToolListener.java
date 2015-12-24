package presentation.logisticsui.deliverymanui.listener.toollistener;

import java.awt.event.ActionEvent;

import presentation.mainui.ToolPane;
import presentation.logisticsui.deliverymanui.DeliveryManFrame;
import presentation.logisticsui.deliverymanui.datapane.ReceivingDataPane;
import presentation.logisticsui.deliverymanui.inputframe.ReceivingInputFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.logisticvo.SendBillVO;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;

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
                ToolPane tool = super.getTool();
                if(e.getSource() == tool.getButton(0)){
                        ui.paintdata(null);
                        ReceivingInputFrame frame = new ReceivingInputFrame(this);
                        frame.setVisible(true);
                }else{
                        logisticsBLService.endReceipt();
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
}
