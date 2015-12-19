package presentation.logisticsui.businessofficeclerkui.listerner.toollistener;

import java.awt.event.ActionEvent;

import presentation.ToolPane;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.inputframe.DriverIdInputFrame;
import presentation.logisticsui.businessofficeclerkui.inputframe.DriverMessageInputFrame;
import presentation.storeui.listener.ToolListener;

public class DriverMessageToolListener extends ToolListener{
        private BusinessOfficeClerkFrame ui;
        
        public BusinessOfficeClerkFrame getUi() {
                return ui;
        }

        public DriverMessageToolListener(BusinessOfficeClerkFrame ui) {
                super();
                this.ui = ui;
        }
        
//        public boolean addInput(DriverMessageVO driverMessageVO) {
//                ResultMessage resultMessage = infoBLSerivce.addDriverMessage(driverMessageVO);
//                if(resultMessage.getKey().equals("SUCCESS")){
//                        return true;
//                }
//                return false;
//        }
//        
//        public boolean modInput(DriverMessageVO driverMessageVO) {
//                ResultMessage resultMessage = infoBLSerivce.modDriverMessage(driverMessageVO);
//                if(resultMessage.getKey().equals("SUCESS"))
//                        return true;
//                return false;
//        }
//        
//        public boolean delInput(String id) {
//                ResultMessage resultMessage = infoBLSerivce.delDriverMessage(id);
//                if(resultMessage.getKey().equals("SUCCESS"))
//                        return true;
//                return false;
//        }
//        
//        public boolean show(String id) {
//                ResultMessage resultMessage = infoBLSerivce.showDriverMessage(id);
//                if(resultMessage.getKey().equals("SUCCESS")){
//                        
//                        return true;
//                }
//                return false;
//        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                ToolPane tool = super.getTool();
                if(e.getSource() == tool.getButton(0)){
                        DriverMessageInputFrame driverMessageInputFrame = new DriverMessageInputFrame(this);
                        driverMessageInputFrame.setVisible(true);
                }else if(e.getSource() == tool.getButton(1)){
                        DriverIdInputFrame driverIdInputFrame = new DriverIdInputFrame(this, 1);
                        driverIdInputFrame.setVisible(true);
                }else if(e.getSource() == tool.getButton(2)){
                        DriverIdInputFrame driverIdInputFrame = new DriverIdInputFrame(this, 0);
                        driverIdInputFrame.setVisible(true);
                }else if(e.getSource() == tool.getButton(3)){
                        DriverIdInputFrame driverIdInputFrame = new DriverIdInputFrame(this, -1);
                        driverIdInputFrame.setVisible(true);
                }else{
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
        
}
