package presentation.financeui.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.financeui.FinanceFrame;
import util.PayItem;
import util.PublicMessage;
import util.Time;
import vo.financevo.PayBillVO;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class PayDialog extends JDialog {

    private JTextField payPersonID;
    private JTextField payMoney;
    private JTextField payAccountID;
    private JComboBox<String> payItem;
    private JTextField payRemark;
    private PayBillVO payBillVO;
    
    public PayDialog(FinanceFrame ui) {
        super(ui);
        init(ui);
    }

    private void init(Frame ui) {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = new JPanel();

        JButton ok = new JButton("确定");
        ok.setBounds(150, 280, 100, 40);
        ok.addActionListener(new okListener());

        JLabel personID = new JLabel("付款人ID");
        personID.setBounds(50, 20, 80, 50);

        payPersonID = new JTextField();
        payPersonID.setBounds(150, 30, 150, 30);

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
        panel.add(ok);
        panel.add(personID);
        panel.add(payPersonID);
        panel.add(money);
        panel.add(payMoney);
        panel.add(accountID);
        panel.add(payAccountID);
        panel.add(item);
        panel.add(payItem);
        panel.add(remark);
        panel.add(payRemark);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	String staffID = PublicMessage.staffID;
            BigDecimal money = new BigDecimal(payMoney.getText());
            String accountID = payAccountID.getText();
            PayItem item = PayItem.getItem((String) payItem.getSelectedItem());
            String remark = payRemark.getText();
            Time current = new Time();
            String id = "12345";
            payBillVO = new PayBillVO(current, money, staffID, accountID, id, item, remark);
            close();
        }
    }

    private void close() {
        this.setVisible(false);
    }
    
    public PayBillVO getPayBillVO() {
    	return payBillVO;
    }
}
