package presentation.logisticsui.transitcenterclerkui.listener.toollistener;

import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import presentation.logisticsui.transitcenterclerkui.inputframe.GoodsRecInputFrame;
import presentation.storeui.listener.ToolListener;
import presentation.storeui.tool.GetButtonOfTool;
import util.ResultMessage;
import vo.logisticvo.ArrivalBillVO;

import java.awt.event.ActionEvent;



public class GoodsRecToolListener extends ToolListener {
        private LogisticsBLService logisticsBLService;
        private TransitCenterclerkFrame ui;
        
        public GoodsRecToolListener(TransitCenterclerkFrame ui) {
                super();
                this.ui = ui;
                this.logisticsBLService = ui.getController();
        }
        
        public boolean getInput(ArrivalBillVO arrivalBillVO) {
                ResultMessage resultMessage = logisticsBLService.produceArrivalBill(arrivalBillVO);
                if(resultMessage.getKey().equals("SUCCESS")){
                        ui.paintdata(null);
                        return true;
                }else {
                        return false;
                }
                
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                GetButtonOfTool tool = super.getTool();
                if(e.getSource() == tool.getButton(0)){
                        GoodsRecInputFrame frame = new GoodsRecInputFrame(this);
                        frame.setVisible(true);
                }else{
                        logisticsBLService.endReceipt();
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
}
