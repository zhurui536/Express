package presentation.financeui.dialog;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.FinanceFrame;
import util.ResultMessage;
import vo.financevo.BankAccountVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountAddDialog extends JDialog {

    private JTextField acID;
    private JTextField acName;
    private JTextField acBalance;
    private FinanceBLService financeController;

    public BankAccountAddDialog(FinanceFrame ui) {
        super(ui);
        init(ui);
        financeController = ui.getFinanceController();
    }

    private void init(Frame ui) {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = new JPanel();

        JButton ok = new JButton("确定");
        ok.setBounds(150, 180, 100, 40);
        ok.addActionListener(new okListener());

        JLabel id = new JLabel("账号ID");
        id.setBounds(50, 20, 80, 50);

        acID = new JTextField();
        acID.setBounds(150, 30, 150, 30);

        JLabel name = new JLabel("账号名称");
        name.setBounds(50, 70, 80, 50);

        acName = new JTextField();
        acName.setBounds(150, 80, 150, 30);

        JLabel balance = new JLabel("余额");
        balance.setBounds(50, 120, 80, 50);

        acBalance = new JTextField();
        acBalance.setBounds(150, 130, 150, 30);

        panel.setLayout(null);
        panel.add(ok);
        panel.add(id);
        panel.add(acID);
        panel.add(name);
        panel.add(acName);
        panel.add(balance);
        panel.add(acBalance);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = acName.getText();
            BigDecimal balance = new BigDecimal(acBalance.getText());
            String id = acID.getText();
            BankAccountVO vo = new BankAccountVO(name, balance, id);
            ResultMessage msg = financeController.createMember(vo);
            if (isFail(msg)) {
                // TODO
                System.err.println("fail");
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
