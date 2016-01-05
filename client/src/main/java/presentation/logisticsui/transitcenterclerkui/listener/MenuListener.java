package presentation.logisticsui.transitcenterclerkui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import presentation.logisticsui.transitcenterclerkui.listener.toollistener.BillCheckToolListener;
import presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsLoadToolListener;
import presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsRecToolListener;
import presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsTranToolListener;
import presentation.logisticsui.transitcenterclerkui.tool.BillCheckTool;
import presentation.logisticsui.transitcenterclerkui.tool.GoodsLoadTool;
import presentation.logisticsui.transitcenterclerkui.tool.GoodsRecTool;
import presentation.logisticsui.transitcenterclerkui.tool.GoodsTranTool;


public class MenuListener implements ActionListener{

        TransitCenterclerkFrame ui;
        
        public MenuListener(TransitCenterclerkFrame ui) {
                super();
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
                        GoodsRecToolListener goodsRecToolListener = new GoodsRecToolListener(ui);
                        GoodsRecTool tool = new GoodsRecTool(goodsRecToolListener);
                        goodsRecToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 1){
                        ui.paintdata(null);
                        GoodsTranToolListener goodsTranToolListener = new GoodsTranToolListener(ui);
                        GoodsTranTool tool = new GoodsTranTool(goodsTranToolListener);
                        goodsTranToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 2){
                        ui.paintdata(null);
                        GoodsLoadToolListener goodsLoadToolListener = new GoodsLoadToolListener(ui);
                        GoodsLoadTool tool = new GoodsLoadTool(goodsLoadToolListener);
                        goodsLoadToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 3){
                        ui.paintdata(null);
                	BillCheckToolListener tl = new BillCheckToolListener(ui);
                	BillCheckTool tool = new BillCheckTool(tl);
                	tl.setTool(tool);
                	ui.replaceTool(tool);
                }
                
        }





        }
