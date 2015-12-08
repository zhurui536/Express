package main.presentation.financeui.dialog;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.financeblservice.FinanceBLService;
import main.presentation.financeui.FinanceFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountDelDialog extends JDialog {

    private JTextField acID;

    private FinanceBLService financeController;

    public BankAccountDelDialog(FinanceFrame ui) {
        super(ui);
        init(ui);
        financeController = ui.getFinanceController();
    }

    private void init(Frame ui) {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 180);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = new JPanel();

        JButton ok = new JButton("确定");
        ok.setBounds(150, 80, 100, 40);
        ok.addActionListener(new okListener());

        JLabel id = new JLabel("账号ID");
        id.setBounds(50, 20, 80, 50);

        acID = new JTextField();
        acID.setBounds(150, 30, 150, 30);

        panel.setLayout(null);
        panel.add(ok);
        panel.add(id);
        panel.add(acID);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = acID.getText();
            ResultMessage msg = financeController.deleteMember(id);
            if (isFail(msg)) {
                // TODO
            } else {
                System.out.println(msg.getKey());
                close();
            }
        }
    }

    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }

    private void close() {
//        acID.setText("");
        this.setVisible(false);
    }
}
