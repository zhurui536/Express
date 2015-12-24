package presentation.financeui.dialog;

import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import vo.financevo.BankAccountVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/8
 */

public class BankAccountFindDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField acID;
    private JTextField acName;
    private BankAccountVO bankAccountVO;
    private FinanceFrame ui;

    public BankAccountFindDialog(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
        init();
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
            String name = acName.getText();
            String id = acID.getText();
            boolean success = check(name, id);
            if (success) {
                name = name.length() == 0 ? null : name;
                id = id.length() == 0 ? null : id;
                bankAccountVO = new BankAccountVO(name, null, id);
                close();
            }
        }
    }

    private boolean check(String name, String id) {
        if (name.length() == 0 && id.length() == 0) {
            new WarningDialog(ui, "请输入账户名称或id");
            return false;
        }
        return true;
    }

    private void close() {
        this.setVisible(false);
    }
    
    public BankAccountVO getBankAccountVO() {
    	return bankAccountVO;
    }
}
