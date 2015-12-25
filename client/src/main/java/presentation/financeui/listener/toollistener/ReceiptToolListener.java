package presentation.financeui.listener.toollistener;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.ReceiptPanel;
import presentation.financeui.dialog.ReceiptDialog;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.tool.ToolPanel;
import util.ResultMessage;
import util.Time;
import vo.logisticvo.ReceiptBillVO;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * 查看收款单监听
 * Created by Away
 * 2015/12/9
 */

public class ReceiptToolListener extends ToolListener {
	
	FinanceBLService financeController;
	
    public ReceiptToolListener(FinanceFrame ui) {
        super(ui);
        financeController = ui.getFinanceController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        ToolPanel toolPanel = ui.getToolPanel();
        ui.paintData(new JPanel());
        
        if (button == toolPanel.getButton("show")) {
            ReceiptDialog dialog = new ReceiptDialog(ui);
            dialog.setVisible(true);
            
            Time time = dialog.getTime();
            String id = dialog.getID();
            if (time != null && id != null) {
                processShow(time, id);
            }
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
        }
    }

	private void processShow(Time time, String id) {
		ResultMessage msg = financeController.showReceipt(time, id);
		if (isFail(msg)) {
            new WarningDialog(ui, "生成失败！");
		} else {
			@SuppressWarnings("unchecked")
			java.util.List<ReceiptBillVO> billVOList = (java.util.List<ReceiptBillVO>) msg.getValue();
			ReceiptPanel receiptPanel = new ReceiptPanel(billVOList);
			ui.paintData(receiptPanel);
            new WarningDialog(ui, "生成成功！");
		}	
	}

	private boolean isFail(ResultMessage msg) {
		return msg.getValue().equals("fail");
	}
	
}
