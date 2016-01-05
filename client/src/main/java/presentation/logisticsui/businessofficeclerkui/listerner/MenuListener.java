package presentation.logisticsui.businessofficeclerkui.listerner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bussinesslogicservice.infoblservice.InfoBLSerivce;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.WarningDialog;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.datapane.DriverMessageListPanel;
import presentation.logisticsui.businessofficeclerkui.datapane.TruckMessageListPanel;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.BillCheckToolListener;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.DriverMessageToolListener;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsDelivToolListener;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsLoadToolListener;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsRecToolListener;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.TruckMessageToolListener;
import presentation.logisticsui.businessofficeclerkui.tool.BillCheckTool;
import presentation.logisticsui.businessofficeclerkui.tool.DriverMessageTool;
import presentation.logisticsui.businessofficeclerkui.tool.GoodsDelivTool;
import presentation.logisticsui.businessofficeclerkui.tool.GoodsLoadTool;
import presentation.logisticsui.businessofficeclerkui.tool.GoodsRecTool;
import presentation.logisticsui.businessofficeclerkui.tool.TruckMessageTool;
import util.ResultMessage;
import vo.DriverMessageVO;
import vo.TruckMessageVO;


public class MenuListener implements ActionListener{
        
        private BusinessOfficeClerkFrame ui;
        
        public MenuListener(BusinessOfficeClerkFrame ui) {
                this.ui = ui;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                int i=0;
                while (true) {// 找出事件来源
                        if (e.getSource() == ui.getButton(i)) {
                                break;
                        } else {
                                i++;
                        }
                }
                ui.refreshMenu();
                ui.getButton(i).clicked();
                if(i == 0){
                        ui.paintdata(null);
                        GoodsLoadToolListener goodsLoadToolListener = new GoodsLoadToolListener(ui);
                        GoodsLoadTool tool = new GoodsLoadTool(goodsLoadToolListener);
                        goodsLoadToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 1){
                        ui.paintdata(null);
                        GoodsRecToolListener goodsRecToolListener = new GoodsRecToolListener(ui);
                        GoodsRecTool tool = new GoodsRecTool(goodsRecToolListener);
                        goodsRecToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 2){
                        ui.paintdata(null);
                        GoodsDelivToolListener goodsDelivToolListener = new GoodsDelivToolListener(ui);
                        GoodsDelivTool tool = new GoodsDelivTool(goodsDelivToolListener);
                        goodsDelivToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 3){
                        ui.paintdata(null);
                        LogisticsBLService logisticsBLService = ui.getLogisticsBLService();
                        ResultMessage resultMessage = logisticsBLService.produceReceiptBill();
                        if(resultMessage.getKey().equals("SUCCESS")){
                                new WarningDialog(ui, "成功生成收款单");
                        }
                }else if(i == 4){
                        InfoBLSerivce infoBLSerivce = ui.getInfoBLSerivce();
                        ResultMessage resultMessage = infoBLSerivce.showAllDriverMessage();
                        if(resultMessage.getKey().equals("success")){
                                @SuppressWarnings("unchecked")
                                DriverMessageListPanel driverMessageListPanel = new DriverMessageListPanel((ArrayList<DriverMessageVO>) resultMessage.getValue());
                                ui.paintdata(driverMessageListPanel);
                        }else{
                                new WarningDialog(null, resultMessage);
                        }
                        DriverMessageToolListener driverMessageToolListener = new DriverMessageToolListener(ui);
                        DriverMessageTool tool = new DriverMessageTool(driverMessageToolListener);
                        driverMessageToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 5){
                        InfoBLSerivce infoBLSerivce = ui.getInfoBLSerivce();
                        ResultMessage resultMessage = infoBLSerivce.showAllTruckMessage();
                        if(resultMessage.getKey().equals("success")){
                                @SuppressWarnings("unchecked")
                                TruckMessageListPanel truckMessageListPanel = new TruckMessageListPanel((ArrayList<TruckMessageVO>) resultMessage.getValue());
                                ui.paintdata(truckMessageListPanel);
                        }else {
                                new WarningDialog(null, resultMessage);
                        }
                        TruckMessageToolListener truckMessageToolListener = new TruckMessageToolListener(ui);
                        TruckMessageTool tool = new TruckMessageTool(truckMessageToolListener);
                        truckMessageToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 6){
                        ui.paintdata(null);
                	BillCheckToolListener billchecktoollistener = new BillCheckToolListener(ui);
                	BillCheckTool tool = new BillCheckTool(billchecktoollistener);
                	billchecktoollistener.setTool(tool);
                	ui.replaceTool(tool);
                }
                
        }

}
