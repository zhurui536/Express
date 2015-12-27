package presentation.logisticsui.deliverymanui;


import bussinesslogic.logisticsbl.LogisticsBLController;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.logisticsui.deliverymanui.listener.MenuListener;
import presentation.mainui.ExpressFrame;

@SuppressWarnings("serial")
public class DeliveryManFrame extends ExpressFrame{
        
        private LogisticsBLService logisticsBLService;
        
        private MenuListener menulistener;

        private static final String[] NAMES = {"收件","派件","查看信息"};
        
        public static void main(String[] args) {
                DeliveryManFrame deliveryManFrame = new DeliveryManFrame();
                deliveryManFrame.setVisible(true);
                }
        
        public DeliveryManFrame() {
                this.logisticsBLService = new LogisticsBLController();
                menulistener = new MenuListener(this);
                paintmenu(NAMES, menulistener);
                painttool();
        }

        public void close(){
                if(tool == null){
                        this.setVisible(false);
                }
        }
        
        public LogisticsBLService getController(){
                return this.logisticsBLService;
        }
}
