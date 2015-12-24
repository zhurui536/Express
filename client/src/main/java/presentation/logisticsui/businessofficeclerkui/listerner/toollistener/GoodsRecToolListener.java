package presentation.logisticsui.businessofficeclerkui.listerner.toollistener;

import java.awt.event.ActionEvent;

import po.logisticpo.ArrivalBillPO;
import presentation.mainui.ToolPane;
import presentation.billui.datapanel.ArrivalBillDataPane;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.inputframe.GoodsRecInputFrame;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.logisticvo.ArrivalBillVO;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;

public class GoodsRecToolListener extends ToolListener{
        private LogisticsBLService logisticsBLService;
        private BusinessOfficeClerkFrame ui;
        
        public GoodsRecToolListener(BusinessOfficeClerkFrame ui) {
                super();
                this.ui = ui;
                this.logisticsBLService = ui.getLogisticsBLService();
        }
        
        public boolean getInput(ArrivalBillVO arrivalBillVO) {
                ResultMessage resultMessage = logisticsBLService.produceArrivalBill(arrivalBillVO);
                if(resultMessage.getKey().equals("SUCCESS")){
                        ui.paintdata(new ArrivalBillDataPane(new ArrivalBillPO(arrivalBillVO)));
                        return true;
                }else {
                        return false;
                }
                
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        		ToolPane tool = super.getTool();
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
