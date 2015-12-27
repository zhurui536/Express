package presentation.financeui.dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.logisticsui.InputChecker;
import util.MyFont;

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
        ok.setBounds(150, 90, 100, 40);
        ok.addActionListener(new okListener());

        JLabel id = new JLabel("账号ID");
        id.setBounds(90, 20, 80, 50);
        
        JLabel warn = new JLabel("删除后将无法恢复！");
        warn.setForeground(Color.RED);
        warn.setFont(MyFont.getFont1());
        warn.setBounds(130, 50, 200, 50);
        
        acID = new JTextField();
        acID.setBounds(150, 30, 150, 30);

        panel.setLayout(null);
        panel.add(ok);
        panel.add(id);
        panel.add(acID);
        panel.add(warn);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	id = acID.getText();
            boolean success = check(id);
            if (success) {
                close();
            } else {
                id = null;
            }
        }
    }

    private boolean check(String id) {
        if (id.length() == 0) {
            new WarningDialog(ui, "请输入账户ID");
            return false;
        } else if (!InputChecker.isNum(id)) {
        	new WarningDialog(ui, "账户ID必须是数字");
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
