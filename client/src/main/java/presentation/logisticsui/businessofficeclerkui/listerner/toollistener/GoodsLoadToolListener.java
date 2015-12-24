package presentation.logisticsui.businessofficeclerkui.listerner.toollistener;

import java.awt.event.ActionEvent;

import presentation.mainui.ToolPane;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.inputframe.GoodsLoadInputFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.logisticvo.LoadingBillVO;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;

public class GoodsLoadToolListener extends ToolListener{
        private LogisticsBLService logisticsBLService;
        private BusinessOfficeClerkFrame ui;
        
        public GoodsLoadToolListener(BusinessOfficeClerkFrame ui) {
                super();
                this.ui = ui;
                this.logisticsBLService = ui.getLogisticsBLService();
        }
        
        public boolean getInput(LoadingBillVO loadingBillVO){
                ResultMessage resultMessage = logisticsBLService.produceLoadBill(loadingBillVO);
                if(resultMessage.getKey().equals("SUCCESS")){
                        ui.paintdata(null);
                        return true;
                }else {
                        return false;
                }
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        		ToolPane tool = super.getTool();
                if(e.getSource() == tool.getButton(0)){
                        GoodsLoadInputFrame frame = new GoodsLoadInputFrame(this);
                        frame.setVisible(true);
                }else{
                        logisticsBLService.endReceipt();
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
}
