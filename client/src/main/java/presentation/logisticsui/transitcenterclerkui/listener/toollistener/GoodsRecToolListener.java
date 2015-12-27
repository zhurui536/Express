package presentation.logisticsui.transitcenterclerkui.listener.toollistener;

import java.awt.event.ActionEvent;

import presentation.WarningDialog;
import presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import presentation.logisticsui.transitcenterclerkui.inputframe.GoodsRecInputFrame;
import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.logisticvo.ArrivalBillVO;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;

public class GoodsRecToolListener extends ToolListener{
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
                }else if(resultMessage.getKey().equals("FAIL")){
                        new WarningDialog(ui, "无对应的中转单！");
                        return false;
                }else{
                        new WarningDialog(ui, resultMessage);
                        return false;
                }
                
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	MyTool tool = super.getTool();
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
