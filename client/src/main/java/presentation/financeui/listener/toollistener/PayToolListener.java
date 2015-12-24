package presentation.financeui.listener.toollistener;

import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.PayPanel;
import presentation.financeui.dialog.PayDialog;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.tool.ToolPanel;
import util.ResultMessage;
import vo.financevo.PayBillVO;

import javax.swing.*;

import bussinesslogicservice.financeblservice.FinanceBLService;

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
            processPay(payBillVO);
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
        } else {
            System.out.println("0");
        }
    }
    
    private void processPay(PayBillVO payBillVO) {
    	ResultMessage msg = financeController.createPayBill(payBillVO);

        if (isFail(msg)) {
            // TODO
        } else {
            List<PayBillVO> payBillVOList = new ArrayList<>();
            payBillVOList.add(payBillVO);
            PayPanel payPanel = new PayPanel(payBillVOList);
            ui.paintData(payPanel);
        }
		
	}

	private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }
}
