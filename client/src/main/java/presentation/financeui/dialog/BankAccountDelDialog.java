package presentation.financeui.dialog;

import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountDelDialog extends JDialog {

    private JTextField acID;
    
    private String id;

    private FinanceFrame ui;

    public BankAccountDelDialog(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
        id = null;
        init();
    }

    private void init() {
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
        	id = acID.getText();
            boolean success = check(id);
            if (success) {
                close();
            }
        }
    }

    private boolean check(String id) {
        System.out.print(id == null);
        if (id == null) {
            new WarningDialog(ui, "请输入账户ID");
            return false;
        }
        return true;
    }

    private void close() {
        this.setVisible(false);
    }
    
    public String getID() {
    	return id;
    }
}
