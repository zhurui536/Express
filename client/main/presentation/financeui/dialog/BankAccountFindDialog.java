package main.presentation.financeui.dialog;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.FinanceBLService;
import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.datapanel.BankAccountPanel;
import main.vo.financevo.BankAccountVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Away
 * 2015/12/8
 */

public class BankAccountFindDialog extends JDialog {

    private JTextField acID;
    private JTextField acName;
    private FinanceBLService financeController;
    private FinanceFrame ui;

    public BankAccountFindDialog(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
        init();
        financeController = ui.getFinanceController();
    }

    private void init() {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 250);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton ok = new JButton("确定");
        ok.setBounds(150, 130, 100, 40);
        ok.addActionListener(new okListener());

        JLabel id = new JLabel("账号ID");
        id.setBounds(50, 20, 80, 50);

        acID = new JTextField();
        acID.setBounds(150, 30, 150, 30);

        JLabel name = new JLabel("账号名称");
        name.setBounds(50, 70, 80, 50);

        acName = new JTextField();
        acName.setBounds(150, 80, 150, 30);

        panel.setLayout(null);
        panel.add(ok);
        panel.add(id);
        panel.add(acID);
        panel.add(name);
        panel.add(acName);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = acName.getText().isEmpty() ? null : acName.getText();
            String id = acID.getText().isEmpty() ? null : acID.getText();
            BankAccountVO vo = new BankAccountVO(name, null, id);
            ResultMessage msg = financeController.inquireMember(vo);
            if (isFail(msg)) {
                // TODO
            } else {
                processData(id, msg);
                close();
            }
        }
    }

    private void processData(String id, ResultMessage msg) {
        java.util.List<BankAccountVO> bankAccountVOs;
        if (id == null) {
            bankAccountVOs = (java.util.List<BankAccountVO>) msg.getValue();
        } else {
            bankAccountVOs = new ArrayList<>();
            BankAccountVO bankAccountVO = (BankAccountVO) msg.getValue();
            bankAccountVOs.add(bankAccountVO);
        }

        BankAccountPanel bankAccountPanel = new BankAccountPanel(bankAccountVOs);
        ui.paintData(bankAccountPanel);
    }

    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }

    private void close() {
//        acName.setText("");
//        acBalance.setText("");
//        acID.setText("");
        this.setVisible(false);
    }

}
