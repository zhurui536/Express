package presentation.financeui.dialog;

import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.logisticsui.InputChecker;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.ResultMessage;
import vo.financevo.BankAccountVO;

import javax.swing.*;

import bussinesslogicservice.financeblservice.FinanceBLService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountAddDialog extends InputFrame {

    private JTextField acID;
    private JTextField acName;
    private JTextField acBalance;
    private FinanceFrame ui;
    private FinanceBLService financeController;
    
    public BankAccountAddDialog(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
       	financeController = ui.getFinanceController();
        init();
    }
    
    private void init() {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 300);
        this.setBackgroundSize(400, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = new JPanel();

        JButton ok = new ToolButton(150, 180,"确定");
        ok.setSize(100, 40);
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
            String balance = acBalance.getText();
            String id = acID.getText();
            boolean success = check(name, balance, id);
            if (success) {
            	BankAccountVO bankAccountVO = new BankAccountVO(name, new BigDecimal(balance), id);
            	processAdd(bankAccountVO);
            }
        }
    }

    private boolean check(String name, String balance, String id) {
        if (name.length() == 0) {
            new WarningDialog(ui, "请输入账户名称");
            return false;
        } else if (balance.length() == 0) {
            new WarningDialog(ui, "请输入账户余额");
            return false;
        } else if (id.length() == 0) {
            new WarningDialog(ui, "请输入账户ID");
            return false;
        } else if (!InputChecker.isNum(balance)) {
        	new WarningDialog(ui, "账户余额必须是数字");
        	return false;
        } else if (InputChecker.isMinus(balance)) {
        	new WarningDialog(ui, "账户余额不能是负数");
        	return false;
        } else if (!InputChecker.isNum(id)) {
        	new WarningDialog(ui, "账号ID必须是数字");
        	return false;
        }
        return true;
    }
    
	private void processAdd(BankAccountVO bankAccountVO) {
    	ResultMessage msg = financeController.createMember(bankAccountVO);
    	if (!isSuccess(msg)) {
            new WarningDialog(ui, "账号ID不能相同");
        } else {
        	this.setVisible(false);
        }
	}
	
	private boolean isSuccess(ResultMessage message) {
        return message.getKey().equals("success");
    }
}
