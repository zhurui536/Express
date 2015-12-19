package presentation.logisticsui.businessofficeclerkui.listerner;

import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsDelivToolListener;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsLoadToolListener;
import presentation.logisticsui.businessofficeclerkui.listerner.toollistener.GoodsRecToolListener;
import presentation.logisticsui.businessofficeclerkui.tool.GoodsDelivTool;
import presentation.logisticsui.businessofficeclerkui.tool.GoodsLoadTool;
import presentation.logisticsui.businessofficeclerkui.tool.GoodsRecTool;
import util.ResultMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
                if(i == 0){
                        GoodsLoadToolListener goodsLoadToolListener = new GoodsLoadToolListener(ui);
                        GoodsLoadTool tool = new GoodsLoadTool(goodsLoadToolListener);
                        goodsLoadToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 1){
                        GoodsRecToolListener goodsRecToolListener = new GoodsRecToolListener(ui);
                        GoodsRecTool tool = new GoodsRecTool(goodsRecToolListener);
                        goodsRecToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 2){
                        GoodsDelivToolListener goodsDelivToolListener = new GoodsDelivToolListener(ui);
                        GoodsDelivTool tool = new GoodsDelivTool(goodsDelivToolListener);
                        goodsDelivToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 3){
                        LogisticsBLService logisticsBLService = ui.getLogisticsBLService();
                        ResultMessage resultMessage = logisticsBLService.produceReceiptBill();
                        if(resultMessage.getKey().equals("SUCCESS")){
                                JDialog dialog = new JDialog();
                                JPanel panel = new JPanel();
                                dialog.setLayout(null);
                                dialog.setLocation(350,200);
                                dialog.setSize(150,50);
                                panel.setSize(150,50);
                                panel.add(new JLabel("Success"));
                                dialog.setContentPane(panel);
                                dialog.setVisible(true);
                        }
                }else if(i == 4){
                        
                }else if(i == 5){
                        
                }
                
        }

}
