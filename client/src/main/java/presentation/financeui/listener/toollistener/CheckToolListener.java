package presentation.financeui.listener.toollistener;

import java.awt.event.ActionEvent;
import java.util.List;

import po.BillPO;
import presentation.WarningDialog;
import presentation.billui.datapanel.BillListPane;
import presentation.financeui.FinanceFrame;
import presentation.financeui.listener.ToolListener;
import presentation.mainui.ExpressFrame;
import presentation.mainui.component.MyTool;
import util.ResultMessage;

public class CheckToolListener extends ToolListener {

	public CheckToolListener(ExpressFrame ui) {
		super(ui);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		FinanceFrame ui = (FinanceFrame) this.ui;
        Object button = e.getSource();
        MyTool toolPanel = ui.getTool();
        
        if (button == toolPanel.getButton(0)) {
        	ResultMessage message = financeController.getAllPayBill();
        	if (isValidMsg(message)) {
        		BillListPane billListPane = new BillListPane((List<? extends BillPO>) message.getValue());
        		ui.paintdata(billListPane);
        	} else {
        		new WarningDialog(ui, "读取失败");
        	}
        }
	}
	
	private boolean isValidMsg(ResultMessage message) {
        return message.getKey().equals("success");
    }
}
