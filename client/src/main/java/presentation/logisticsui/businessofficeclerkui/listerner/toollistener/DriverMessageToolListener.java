package presentation.logisticsui.businessofficeclerkui.listerner.toollistener;

import java.awt.event.ActionEvent;

import presentation.mainui.component.MyTool;
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
        
        @Override
        public void actionPerformed(ActionEvent e) {
                MyTool tool = super.getTool();
                if(e.getSource() == tool.getButton(0)){
                        ui.paintdata(null);
                        DriverMessageInputFrame driverMessageInputFrame = new DriverMessageInputFrame(this);
                        driverMessageInputFrame.setVisible(true);
                }else if(e.getSource() == tool.getButton(1)){
                        ui.paintdata(null);
                        DriverIdInputFrame driverIdInputFrame = new DriverIdInputFrame(this, 1);
                        driverIdInputFrame.setVisible(true);
                }else if(e.getSource() == tool.getButton(2)){
                        ui.paintdata(null);
                        DriverIdInputFrame driverIdInputFrame = new DriverIdInputFrame(this, 0);
                        driverIdInputFrame.setVisible(true);
                }else if(e.getSource() == tool.getButton(3)){
                        ui.paintdata(null);
                        DriverIdInputFrame driverIdInputFrame = new DriverIdInputFrame(this, -1);
                        driverIdInputFrame.setVisible(true);
                }else{
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
        
}
