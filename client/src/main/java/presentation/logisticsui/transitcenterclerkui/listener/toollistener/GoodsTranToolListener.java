package presentation.logisticsui.transitcenterclerkui.listener.toollistener;

import java.awt.event.ActionEvent;

import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import presentation.logisticsui.transitcenterclerkui.inputframe.GoodsTranInputFrame;
import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.logisticvo.TransferBillVO;

public class GoodsTranToolListener extends ToolListener{
        private LogisticsBLService logisticsBLService;
        private TransitCenterclerkFrame ui;
        
        public GoodsTranToolListener(TransitCenterclerkFrame ui) {
                super();
                this.ui = ui;
                this.logisticsBLService = ui.getController();
        }
        
        public boolean getInput(TransferBillVO transferBillVO) {
                ResultMessage resultMessage = logisticsBLService.produceTransferBill(transferBillVO);
                if(resultMessage.getKey().equals("SUCCESS")){
                        ui.paintdata(null);
                        return true;
                }else {
                        return false;
                }
                
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                MyTool tool = super.getTool();
                int i;
                for ( i = 0; i < tool.getNumOfButton(); i++) {
                        if(e.getSource() == tool.getButton(i))
                                break;
                }
                
                if(e.getSource() != tool.getButton(3)){
                        GoodsTranInputFrame frame = new GoodsTranInputFrame(this,i);
                        frame.setVisible(true);
                }else{
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
}
