package presentation.logisticsui.businessofficeclerkui;

import bussinesslogic.infobl.InfoBLController;
import bussinesslogic.logisticsbl.LogisticsBLController;
import bussinesslogicservice.infoblservice.InfoBLSerivce;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.logisticsui.businessofficeclerkui.listerner.MenuListener;
import presentation.mainui.ExpressFrame;

@SuppressWarnings("serial")
public class BusinessOfficeClerkFrame extends ExpressFrame {

        private LogisticsBLService logisticsBLService;
        private InfoBLSerivce infoBLSerivce;

        private MenuListener menulistener;

        private static final String[] NAMES = { "货物装车", "货物接受","分派货物","收款", "司机信息维护" ,"车辆信息维护", "审批查看"};

        public static void main(String[] args)  {
                BusinessOfficeClerkFrame frame = new BusinessOfficeClerkFrame();
                frame.setVisible(true);
        }

        public BusinessOfficeClerkFrame() {
                this.logisticsBLService = new LogisticsBLController();
                this.infoBLSerivce = new InfoBLController();

                menulistener = new MenuListener(this);
                paintmenu(NAMES, menulistener);
                painttool();
        }

        public void close() {
                if (tool == null) {
                        this.setVisible(false);
                }
        }

        public LogisticsBLService getLogisticsBLService() {
                return logisticsBLService;
        }

        public InfoBLSerivce getInfoBLSerivce() {
                return infoBLSerivce;
        }

}
