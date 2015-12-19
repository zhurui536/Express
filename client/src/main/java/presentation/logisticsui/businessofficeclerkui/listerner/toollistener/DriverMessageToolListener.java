package presentation.logisticsui.businessofficeclerkui.listerner.toollistener;

import bussinesslogicservice.infoblservice.InfoBLSerivce;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.storeui.listener.ToolListener;

public class DriverMessageToolListener extends ToolListener{
        private InfoBLSerivce infoBLSerivce;
        private BusinessOfficeClerkFrame ui;
        
        public DriverMessageToolListener(BusinessOfficeClerkFrame ui) {
                super();
                this.ui = ui;
                infoBLSerivce = ui.getInfoBLSerivce();
        }
}
