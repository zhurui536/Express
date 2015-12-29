package presentation.financeui.dialog;

import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import vo.financevo.BankAccountVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/9
 */

public class BankAccountUpdateDialog extends InputFrame {

	private static final long serialVersionUID = 1L;
	private JTextField acID;
    private JTextField afterName;
    private BankAccountVO bankAccountVO;
    private FinanceFrame ui;
    
    public BankAccountUpdateDialog(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 250);
        this.setBackgroundSize(400, 250);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = new JPanel();

        JButton ok = new ToolButton(150, 130,"确定");
        ok.setSize(100, 40);
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
            String name = afterName.getText();
            String id = acID.getText();
            boolean success = check(name, id);
            if (success) {
                bankAccountVO = new BankAccountVO(name, null, id);
                close();
            }
        }
    }

    private boolean check(String name, String id) {
        if (name.length() == 0) {
            new WarningDialog(ui, "请输入账户名称");
            return false;
        } else if (id.length() == 0) {
            new WarningDialog(ui, "请输入账户id");
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
