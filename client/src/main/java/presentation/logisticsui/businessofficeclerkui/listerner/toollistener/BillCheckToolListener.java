package presentation.logisticsui.businessofficeclerkui.listerner.toollistener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import po.logisticpo.ArrivalBillPO;
import po.logisticpo.DeliveryBillPO;
import po.logisticpo.LoadingBillPO;
import po.logisticpo.ReceiptBillPO;
import presentation.billui.datapanel.BillListPane;
import presentation.logisticsui.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.mainui.component.MyTool;
import presentation.storeui.listener.ToolListener;
import util.BillType;
import util.ResultMessage;
import bussinesslogicservice.logisticsblservice.LogisticsBLService;

public class BillCheckToolListener extends ToolListener {
	private BusinessOfficeClerkFrame ui;
	private LogisticsBLService bl;
	
	public BillCheckToolListener(BusinessOfficeClerkFrame ui) {
		super();
		this.ui = ui;
		this.bl = ui.getLogisticsBLService();
	}
	
    @SuppressWarnings("unchecked")
	@Override
    public void actionPerformed(ActionEvent e) {
            MyTool tool = super.getTool();
            ResultMessage result;
            if(e.getSource() == tool.getButton(0)){
                  result = bl.queryBill(BillType.LOADING);
                  if(result.getKey().equals("success")){
					ArrayList<LoadingBillPO> bills = (ArrayList<LoadingBillPO>) result.getValue();
                	  ui.paintdata(new BillListPane(bills));
                  }
            }else if(e.getSource() == tool.getButton(1)){
            	result = bl.queryBill(BillType.ARRIVAL);
                if(result.getKey().equals("success")){
					ArrayList<ArrivalBillPO> bills = (ArrayList<ArrivalBillPO>) result.getValue();
              	  ui.paintdata(new BillListPane(bills));
                }
            }else if(e.getSource() == tool.getButton(2)){
            	result = bl.queryBill(BillType.DELIVERY);
                if(result.getKey().equals("success")){
					ArrayList<DeliveryBillPO> bills = (ArrayList<DeliveryBillPO>) result.getValue();
              	  ui.paintdata(new BillListPane(bills));
                }
            }else if(e.getSource() == tool.getButton(3)){
            	result = bl.queryBill(BillType.RECEIPT);
                if(result.getKey().equals("success")){
					ArrayList<ReceiptBillPO> bills = (ArrayList<ReceiptBillPO>) result.getValue();
              	  ui.paintdata(new BillListPane(bills));
                }
            }else{
            	ui.paintdata(null);
            	ui.replaceTool(null);
            }
    }
}
