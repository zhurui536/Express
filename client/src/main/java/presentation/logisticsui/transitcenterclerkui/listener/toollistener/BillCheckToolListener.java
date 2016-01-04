package presentation.logisticsui.transitcenterclerkui.listener.toollistener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import bussinesslogicservice.logisticsblservice.LogisticsBLService;
import po.logisticpo.ArrivalBillPO;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.TransferBillPO;
import presentation.billui.datapanel.BillListPane;
import presentation.logisticsui.transitcenterclerkui.TransitCenterclerkFrame;
import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;
import util.BillType;
import util.ResultMessage;

public class BillCheckToolListener extends ToolListener {
    private LogisticsBLService bl;
    private TransitCenterclerkFrame ui;
    
    public BillCheckToolListener(TransitCenterclerkFrame ui) {
            super();
            this.ui = ui;
            this.bl = ui.getController();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public void actionPerformed(ActionEvent e) {
            MyTool tool = super.getTool();
            ResultMessage result;
            
            if(e.getSource() == tool.getButton(0)){
            	result = bl.queryBill(BillType.ARRIVAL);
            	if(result.getKey().equals("success")){
					ArrayList<ArrivalBillPO> bills = (ArrayList<ArrivalBillPO>) result.getValue();
              	  ui.paintdata(new BillListPane(bills));
                }
            }else if(e.getSource() == tool.getButton(1)){
            	 result = bl.queryBill(BillType.TRANSIT);
                 if(result.getKey().equals("success")){
					ArrayList<TransferBillPO> bills = (ArrayList<TransferBillPO>) result.getValue();
               	  ui.paintdata(new BillListPane(bills));
                 }
            }else if(e.getSource() == tool.getButton(2)){
            	 result = bl.queryBill(BillType.LOADING);
                 if(result.getKey().equals("success")){
					ArrayList<LoadingBillPO> bills = (ArrayList<LoadingBillPO>) result.getValue();
               	  ui.paintdata(new BillListPane(bills));
                 }
            }else{
            	ui.paintdata(null);
            	ui.replaceTool(null);
            }
    }
}
