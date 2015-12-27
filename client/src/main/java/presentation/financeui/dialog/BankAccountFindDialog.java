package presentation.financeui.dialog;

import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.logisticsui.InputChecker;
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
	private JTextField input;
    private BankAccountVO bankAccountVO;
    private FinanceFrame ui;
    private JComboBox<String> find;
    
    public BankAccountFindDialog(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 380, 220);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = new JPanel();

        JButton ok = new JButton("确定");
        ok.setBounds(150, 100, 100, 40);
        ok.addActionListener(new okListener());

        find = new JComboBox<>();
        find.addItem("账号ID");
        find.addItem("账号名称");
        find.setBounds(50, 40, 100, 30);
        
        input = new JTextField();
        input.setBounds(150, 40, 150, 30);
        
        panel.setLayout(null);
        panel.add(ok);

        panel.add(find);
        panel.add(input);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String in = input.getText();
            String choose = (String) find.getSelectedItem();
            boolean success = check(in, choose);
            if (success) {
            	String id, name;
                if (isID(choose)) {
                	id = in;
                	name = null;
                } else {
                	id = null;
                	name = in;
                }
                bankAccountVO = new BankAccountVO(name, null, id);
                close();
            }
        }
    }

    private boolean check(String in, String choose) {
        if (isID(choose) && in.length() == 0) {
            new WarningDialog(ui, "请输入账户ID");
            return false;
        } else if (!isID(choose) && in.length() == 0) {
        	new WarningDialog(ui, "请输入账户名称");
            return false;
        } else if (isID(choose) && !InputChecker.isNum(in)) {
            new WarningDialog(ui, "账户ID必须是数字");
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
    
    private boolean isID(String choose) {
    	return choose.equals("账号ID");
    }
}
