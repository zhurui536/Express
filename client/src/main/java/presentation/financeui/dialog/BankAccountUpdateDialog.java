package presentation.financeui.dialog;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.FinanceFrame;
import util.ResultMessage;
import vo.financevo.BankAccountVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/9
 */

public class BankAccountUpdateDialog extends JDialog {

    private JTextField acID;
    private JTextField afterName;
    private FinanceBLService financeController;
    private FinanceFrame ui;

    public BankAccountUpdateDialog(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
        init();
        financeController = ui.getFinanceController();
    }

    private void init() {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 250);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = new JPanel();

        JButton ok = new JButton("确定");
        ok.setBounds(150, 130, 100, 40);
        ok.addActionListener(new okListener());

        JLabel id = new JLabel("账号ID");
        id.setBounds(50, 20, 80, 50);

        acID = new JTextField();
        acID.setBounds(150, 30, 150, 30);

        JLabel afName = new JLabel("修改名称");
        afName.setBounds(50, 70, 80, 50);

        afterName = new JTextField();
        afterName.setBounds(150, 80, 150, 30);

        panel.setLayout(null);
        panel.add(ok);
        panel.add(id);
        panel.add(acID);
        panel.add(afName);
        panel.add(afterName);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = afterName.getText().isEmpty() ? null : afterName.getText();
            String id = acID.getText().isEmpty() ? null : acID.getText();
            BankAccountVO vo = new BankAccountVO(name, null, id);
            ResultMessage msg = financeController.updateMember(vo);
            if (isFail(msg)) {
                // TODO
            } else {
                close();
            }
        }
    }


    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }

    private void close() {
        this.setVisible(false);
    }
}
