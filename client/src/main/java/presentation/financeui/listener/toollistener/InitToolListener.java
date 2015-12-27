package presentation.financeui.listener.toollistener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.InitPanel;
import presentation.financeui.listener.ToolListener;
import presentation.mainui.component.MyTool;
import util.ResultMessage;
import util.Time;
import vo.InstitutionMessageVO;
import vo.StaffMessageVO;
import vo.TruckMessageVO;
import vo.financevo.AccountVO;
import vo.financevo.BankAccountVO;
import vo.storevo.StorePlaceVO;
import vo.storevo.StoreVO;

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
        MyTool toolPanel = ui.getTool();
        ui.paintdata(null);
        
        if (button == toolPanel.getButton(0)) {
            initAccount();
        } else if (button == toolPanel.getButton(1)) {
            inquire();
        } else if (button == toolPanel.getButton(2)) {
            ui.replaceTool(null);
        }
    }

    private void inquire() {
        ResultMessage msg = financeController.inquireInitInfo();
        if (isFail(msg)) {
            new WarningDialog(ui, "查询期初账本失败");
        } else {
            AccountVO accountVO = (AccountVO) msg.getValue();
            InitPanel initPanel = new InitPanel(accountVO);
            ui.paintdata(initPanel);
            new WarningDialog(ui, "查询期初账本成功");
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
