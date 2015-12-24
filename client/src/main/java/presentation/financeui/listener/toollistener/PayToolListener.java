package presentation.financeui.listener.toollistener;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.PayPanel;
import presentation.financeui.dialog.PayDialog;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.tool.ToolPanel;
import util.ResultMessage;
import vo.financevo.PayBillVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Away
 * 2015/12/9
 */

public class PayToolListener extends ToolListener {
	
	FinanceBLService financeController;
    public PayToolListener(FinanceFrame ui) {
        super(ui);
        financeController = ui.getFinanceController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        ToolPanel toolPanel = ui.getToolPanel();
        ui.paintData(new JPanel());
        
        if (button == toolPanel.getButton("create")) {
            PayDialog dialog = new PayDialog(ui);
            dialog.setVisible(true);
            PayBillVO payBillVO = dialog.getPayBillVO();
            if (payBillVO != null) {
                processPay(payBillVO);
            }
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
        }
    }
    
    private void processPay(PayBillVO payBillVO) {
    	ResultMessage msg = financeController.createPayBill(payBillVO);

        if (isFail(msg)) {
            new WarningDialog(ui, "创建付款单失败");
        } else {
            List<PayBillVO> payBillVOList = new ArrayList<>();
            payBillVOList.add(payBillVO);
            PayPanel payPanel = new PayPanel(payBillVOList);
            ui.paintData(payPanel);
            new WarningDialog(ui, "成功创建付款单");
        }
		
	}

	private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }
}
