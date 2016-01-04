package presentation.financeui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.PayPanel;
import presentation.logisticsui.InputChecker;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.PayItem;
import util.PublicMessage;
import util.ResultMessage;
import util.Time;
import vo.financevo.PayBillVO;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class PayDialog extends InputFrame {

    private JTextField payMoney;
    private JTextField payAccountID;
    private JComboBox<String> payItem;
    private JTextField payRemark;
    private FinanceFrame ui;
    private FinanceBLService financeController;
    
    public PayDialog(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
        this.financeController = ui.getFinanceController();
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 400);
        this.setBackgroundSize(400, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = (JPanel) this.getContentPane();

        JButton ok = new ToolButton(150, 280,"确定");
        ok.setSize( 100, 40);
        ok.addActionListener(new okListener());

        JLabel personID = new JLabel("付款人ID:               " + PublicMessage.staffID);
        personID.setBounds(50, 20, 180, 50);

        JLabel money = new JLabel("付款金额");
        money.setBounds(50, 70, 80, 50);

        payMoney = new JTextField();
        payMoney.setBounds(150, 80, 150, 30);

        JLabel accountID = new JLabel("付款账号");
        accountID.setBounds(50, 120, 80, 50);

        payAccountID = new JTextField();
        payAccountID.setBounds(150, 130, 150, 30);

        JLabel item = new JLabel("条目");
        item.setBounds(50, 170, 80, 50);

        payItem = new JComboBox<>();
        payItem.addItem("租金");
        payItem.addItem("运费");
        payItem.addItem("工资");
        payItem.addItem("奖励");
        payItem.setBounds(150, 180, 150, 30);

        JLabel remark = new JLabel("备注");
        remark.setBounds(50, 220, 80, 50);

        payRemark = new JTextField();
        payRemark.setBounds(150, 230, 150, 30);

        panel.setLayout(null);
        panel.add(ok, 0);
        panel.add(personID, 0);
        panel.add(money, 0);
        panel.add(payMoney, 0);
        panel.add(accountID, 0);
        panel.add(payAccountID, 0);
        panel.add(item, 0);
        panel.add(payItem, 0);
        panel.add(remark, 0);
        panel.add(payRemark, 0);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	String staffID = PublicMessage.staffID;
            String money = payMoney.getText();
            String accountID = payAccountID.getText();
            PayItem item = PayItem.getItem((String) payItem.getSelectedItem());
            String remark = payRemark.getText();
            Time current = new Time();
            boolean success = check(money, accountID, remark);
            if (success) {
                PayBillVO payBillVO = new PayBillVO(current, new BigDecimal(money), staffID, accountID, null, item, remark);
                processPay(payBillVO);
            }
        }
    }

    private boolean check(String money, String accountID, String remark) {
        if (money.length() == 0) {
            new WarningDialog(ui, "请输入付款金额");
            return false;
        } else if (accountID.length() == 0) {
            new WarningDialog(ui, "请输入付款账号ID");
            return false;
        } else if (remark.length() == 0) {
            new WarningDialog(ui, "请输入备注");
            return false;
        } else if (!InputChecker.isNum(money)) {
        	new WarningDialog(ui, "付款金额必须是数字");
        	return false;
        } else if (InputChecker.isMinus(money)) {
        	new WarningDialog(ui, "付款金额必须为整数");
        	return false;
        }
        return true;
    }
    
    private void processPay(PayBillVO payBillVO) {
    	ResultMessage msg = financeController.createPayBill(payBillVO);

        if (MoneyNotEnough(msg)) {
            new WarningDialog(ui, "该账户没有足够的余额");
        } else if (IDNotFound(msg)) {
        	new WarningDialog(ui, "未找到该用户");
        }
        else {
        	payBillVO.id = (String) msg.getValue();
            List<PayBillVO> payBillVOList = new ArrayList<>();
            payBillVOList.add(payBillVO);
            PayPanel payPanel = new PayPanel(payBillVOList);
            ui.paintdata(payPanel);
            this.setVisible(false);
        }
	}
    
    private boolean MoneyNotEnough(ResultMessage message) {
        return message.getKey().equals("money not enough");
    }
	
	private boolean IDNotFound(ResultMessage message) {
        return message.getKey().equals("id not found");
    }
	
}
