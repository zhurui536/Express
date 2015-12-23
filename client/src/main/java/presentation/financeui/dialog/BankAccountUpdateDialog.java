package presentation.financeui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.financeui.FinanceFrame;
import vo.financevo.BankAccountVO;

/**
 * Created by Away
 * 2015/12/9
 */

public class BankAccountUpdateDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField acID;
    private JTextField afterName;
    private BankAccountVO bankAccountVO;
    
    public BankAccountUpdateDialog(FinanceFrame ui) {
        super(ui);
        init(ui);
    }

    private void init(FinanceFrame ui) {
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
            bankAccountVO = new BankAccountVO(name, null, id);
            close();
        }
    }

    private void close() {
        this.setVisible(false);
    }
    
    public BankAccountVO getBankAccountVO() {
    	return bankAccountVO;
    }
}
