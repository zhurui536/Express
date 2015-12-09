package main.presentation.logisticsui.transitcenterclerkui.listener.toollistener;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.logisticsblservice.LogisticsBLService;
import main.presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import main.presentation.storeui.listener.ToolListener;
import main.vo.logisticvo.ArrivalBillVO;

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
                }else {
                        return false;
                }
                
        }
}
