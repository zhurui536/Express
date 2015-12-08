package main.presentation.financeui.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountAddDialog extends JDialog {

    private JButton ok;
    private JTextField acID;
    private JTextField acName;
    private JTextField acBalance;
    private JLabel id;
    private JLabel name;
    private JLabel balance;
    private JPanel jPanel;

    public BankAccountAddDialog(Frame ui) {
        super(ui);
        init(ui);
    }

    private void init(Frame ui) {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ok = new JButton("确定");
        ok.setBounds(150, 210, 100, 40);
        ok.addActionListener(new okListener());
        this.add(ok);


    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
