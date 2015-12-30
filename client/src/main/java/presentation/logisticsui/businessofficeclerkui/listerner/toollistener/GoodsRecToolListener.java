package presentation.logisticsui.businessofficeclerkui.listerner.toollistener;

import java.awt.event.ActionEvent;

import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import po.logisticpo.ArrivalBillPO;
import presentation.WarningDialog;
import presentation.billui.datapanel.ArrivalBillDataPane;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.inputframe.GoodsRecInputFrame;
import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.logisticvo.ArrivalBillVO;

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
