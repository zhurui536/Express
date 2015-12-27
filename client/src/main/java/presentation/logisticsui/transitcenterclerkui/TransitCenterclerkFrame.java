package presentation.logisticsui.transitcenterclerkui;

import bussinesslogic.logisticsbl.LogisticsBLController;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.logisticsui.transitcenterclerkui.listener.MenuListener;
import presentation.mainui.ExpressFrame;



@SuppressWarnings("serial")
public class TransitCenterclerkFrame extends ExpressFrame {

        private LogisticsBLService logisticsBLService;

        private MenuListener menulistener;

        private static final String[] NAMES = { "货物接受", "货物转运", "货物装车" };

        public TransitCenterclerkFrame() {
            this.logisticsBLService = new LogisticsBLController();
                menulistener = new MenuListener(this);
                paintmenu(NAMES, menulistener);
                painttool();
        }

        public static void main(String[] args) {
                TransitCenterclerkFrame frame = new TransitCenterclerkFrame();
                frame.setVisible(true);
        }

        public void close() {
                if (tool == null) {
                        this.setVisible(false);
                }
        }

        public LogisticsBLService getController() {
                return this.logisticsBLService;
        }
}
