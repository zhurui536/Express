package main.presentation.logisticsui.transitcenterclerkui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import main.presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsLoadToolListener;
import main.presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsRecToolListener;
import main.presentation.logisticsui.transitcenterclerkui.listener.toollistener.GoodsTranToolListener;
import main.presentation.logisticsui.transitcenterclerkui.tool.GoodsLoadTool;
import main.presentation.logisticsui.transitcenterclerkui.tool.GoodsRecTool;
import main.presentation.logisticsui.transitcenterclerkui.tool.GoodsTranTool;

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
                if(i == 0){
                        GoodsRecToolListener goodsRecToolListener = new GoodsRecToolListener(ui);
                        GoodsRecTool tool = new GoodsRecTool(goodsRecToolListener);
                        goodsRecToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 1){
                        GoodsTranToolListener goodsTranToolListener = new GoodsTranToolListener(ui);
                        GoodsTranTool tool = new GoodsTranTool(goodsTranToolListener); 
                        goodsTranToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }else if(i == 2){
                        GoodsLoadToolListener goodsLoadToolListener = new GoodsLoadToolListener(ui);
                        GoodsLoadTool tool = new GoodsLoadTool(goodsLoadToolListener);
                        goodsLoadToolListener.setTool(tool);
                        ui.replaceTool(tool);
                }
                
        }





        }
