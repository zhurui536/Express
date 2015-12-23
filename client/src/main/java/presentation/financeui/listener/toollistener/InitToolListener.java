package presentation.financeui.listener.toollistener;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.InitPanel;
import presentation.financeui.listener.ToolListener;
import presentation.financeui.tool.ToolPanel;
import util.ResultMessage;
import util.Time;
import vo.InstitutionMessageVO;
import vo.StaffMessageVO;
import vo.TruckMessageVO;
import vo.financevo.AccountVO;
import vo.financevo.BankAccountVO;
import vo.storevo.StorePlaceVO;
import vo.storevo.StoreVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by Away
 * 2015/12/9
 */

public class InitToolListener extends ToolListener {

    FinanceBLService financeController;

    public InitToolListener(FinanceFrame ui) {
        super(ui);
        financeController = ui.getFinanceController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        ToolPanel toolPanel = ui.getToolPanel();
        ui.paintData(new JPanel());
        
        if (button == toolPanel.getButton("create")) {
            initAccount();
        } else if (button == toolPanel.getButton("inquire")) {
            inquire();
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
        } else {
            System.out.println("0");
        }
    }

    private void inquire() {
        ResultMessage msg = financeController.inquireInitInfo();
        if (isFail(msg)) {
            // TODO
        } else {
            AccountVO accountVO = (AccountVO) msg.getValue();
            InitPanel initPanel = new InitPanel(accountVO);
            ui.paintData(initPanel);
        }
    }

    private void initAccount() {
        AccountVO accountVO = new AccountVO(new InstitutionMessageVO(),
                new StaffMessageVO(), new TruckMessageVO(), new StoreVO(new ArrayList<StorePlaceVO>(), 0, 0, 0, 0), new BankAccountVO(), new Time());
        financeController.createAccounting(accountVO);
    }

    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }
}
