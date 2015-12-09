package main.presentation.financeui.listener.toollistener;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.FinanceBLService;
import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.datapanel.InitPanel;
import main.presentation.financeui.listener.ToolListener;
import main.presentation.financeui.tool.ToolPanel;
import main.vo.InstitutionMessageVO;
import main.vo.StaffMessageVO;
import main.vo.TruckMessageVO;
import main.vo.financevo.AccountVO;
import main.vo.financevo.BankAccountVO;
import main.vo.storevo.StorePlaceVO;
import main.vo.storevo.StoreVO;

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

        if (button == toolPanel.getButton("create")) {
            ui.paintData(new JPanel());
            initAccount();
        } else if (button == toolPanel.getButton("inquire")) {
            ui.paintData(new JPanel());
            inquire();
        } else if (button == toolPanel.getButton("back")) {
            ui.replaceTool(new ToolPanel());
            ui.paintData(new JPanel());
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
