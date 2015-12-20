package presentation.logisticsui.businessofficeclerkui.listerner.toollistener;

import java.awt.event.ActionEvent;

import presentation.ToolPane;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.inputframe.TruckIdInputFrame;
import presentation.logisticsui.businessofficeclerkui.inputframe.TruckMessageInputFrame;
import presentation.storeui.listener.ToolListener;

public class TruckMessageToolListener extends ToolListener{
        private BusinessOfficeClerkFrame ui;
        
        public BusinessOfficeClerkFrame getUi() {
                return ui;
        }
        
        public TruckMessageToolListener(BusinessOfficeClerkFrame ui) {
                super();
                this.ui = ui;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                ToolPane tool = super.getTool();
                if(e.getSource() == tool.getButton(0)){
                        ui.paintdata(null);
                        TruckMessageInputFrame truckMessageInputFrame = new TruckMessageInputFrame(this);
                        truckMessageInputFrame.setVisible(true);
                }else if(e.getSource() == tool.getButton(1)){
                        ui.paintdata(null);
                        TruckIdInputFrame truckIdInputFrame = new TruckIdInputFrame(this, 1);
                        truckIdInputFrame.setVisible(true);
                }else if(e.getSource() == tool.getButton(2)){
                        ui.paintdata(null);
                        TruckIdInputFrame truckIdInputFrame = new TruckIdInputFrame(this, 0);
                        truckIdInputFrame.setVisible(true);
                }else if(e.getSource() == tool.getButton(3)){
                        ui.paintdata(null);
                        TruckIdInputFrame truckIdInputFrame = new TruckIdInputFrame(this, -1);
                        truckIdInputFrame.setVisible(true);
                }else{
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }
        }
}
