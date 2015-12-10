package presentation.financeui.datapanel;


import vo.financevo.StatementVO;

import javax.swing.*;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class StatementPanel extends JPanel {

    private StatementVO statementVO;

    private JPanel receiptPanel;

    private JPanel payPanel;

    public StatementPanel(StatementVO statementVO) {
        this.statementVO = statementVO;

        this.setLayout(null);
        initPanel();
        this.setSize(830, receiptPanel.getHeight() + payPanel.getHeight() + 200);
    }

    private void initPanel() {
        JLabel receipt = new JLabel("收款单");
        receipt.setBounds(5, 20, 100, 30);


        receiptPanel = new ReceiptPanel(statementVO.receiptBillVOs);
        receiptPanel.setLocation(0, 60);

        JLabel pay = new JLabel("付款单");
        pay.setBounds(5, 100 + receiptPanel.getHeight(), 100, 30);

        payPanel = new PayPanel(statementVO.payBillVOs);
        payPanel.setLocation(0, receiptPanel.getHeight() + 150);

        this.add(receiptPanel);
        this.add(payPanel);
        this.add(receipt);
        this.add(pay);
    }
}
