package presentation.logisticsui.transitcenterclerkui.listener.toollistener;

import java.awt.event.ActionEvent;

import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import presentation.WarningDialog;
import presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import presentation.logisticsui.transitcenterclerkui.data.GoodsListDataPane;
import presentation.logisticsui.transitcenterclerkui.inputframe.GoodsIDInputFrame;
import presentation.logisticsui.transitcenterclerkui.inputframe.GoodsLoadInputFrame;
import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;
import util.ResultMessage;
import vo.logisticvo.LoadingBillVO;

public class GoodsLoadToolListener extends ToolListener{
        private LogisticsBLService logisticsBLService;
        private TransitCenterclerkFrame ui;
        private LoadingBillVO vo;
        
        public GoodsLoadToolListener(TransitCenterclerkFrame ui) {
                super();
                this.ui = ui;
                this.logisticsBLService = ui.getController();
        }
        
        public boolean getInput(LoadingBillVO loadingBillVO){
        	vo = loadingBillVO;
        	GoodsListDataPane data = new GoodsListDataPane(vo.ids, this);
    		ui.paintdata(data);
//                ResultMessage resultMessage = logisticsBLService.produceLoadBill(vo);
//                if(resultMessage.getKey().equals("SUCCESS")){
//                        ui.paintdata(null);
//                        return true;
//                }else{
//                        return false;
//                }
        	return true;
        }
        
        public boolean getID(String id){
        	for(int i=0;i<vo.ids.size();i++){
        		if(vo.ids.get(i).equals(id)){
        			new WarningDialog(ui, "不能重复输入！");
        			return false;
        		}
        	}
        	
        	ResultMessage result = this.logisticsBLService.addGoods(id);
        	if(result.getKey().equals("exist")){
        		vo.ids.add(id);
        		GoodsListDataPane data = new GoodsListDataPane(vo.ids, this);
        		ui.paintdata(data);
        		return true;
        	}
        	else if(result.getKey().equals("nogoods")){
        		new WarningDialog(ui, "货物不存在！");
        		return false;
        	}
        	else{
        		new WarningDialog(ui, "网络连接出错");
        		return false;
        	}
        }
        
        public void deleteID(String id){
        	for(int i=0;i<vo.ids.size();i++){
        		if(vo.ids.get(i).equals(id)){
        			vo.ids.remove(i);
        			GoodsListDataPane data = new GoodsListDataPane(vo.ids, this);
            		ui.paintdata(data);
        			break;
        		}
        	}
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
                MyTool tool = super.getTool();
                if(e.getSource() == tool.getButton(0)){
                        GoodsLoadInputFrame frame = new GoodsLoadInputFrame(this);
                        frame.setVisible(true);
                }else if(e.getSource() == tool.getButton(3)){
                        logisticsBLService.endReceipt();
                        ui.replaceTool(null);
                        ui.paintdata(null);
                }else if(e.getSource() == tool.getButton(1)){
	                  if(vo == null){
	                	  new WarningDialog(ui, "请先填写装车单信息");
	                  }
	                  else{
	                	  ResultMessage resultMessage = logisticsBLService.produceLoadBill(vo);
		                  if(resultMessage.getKey().equals("SUCCESS")){
		                          ui.paintdata(null);
		                          vo = null;
		                          new WarningDialog(ui, "装车单生成成功");
		                  }
		                  else{
		                	  new WarningDialog(ui, "装车单生成失败");
		                  }
	                  }
                }else if(e.getSource() == tool.getButton(2)){
                	if(vo == null){
                		new WarningDialog(ui, "请先填写装车单信息");
                	}
                	else{
                		GoodsIDInputFrame frame = new GoodsIDInputFrame(this);
                        frame.setVisible(true);
                	}
                }
        }
}
