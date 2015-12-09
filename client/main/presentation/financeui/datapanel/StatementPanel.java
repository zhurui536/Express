package main.presentation.financeui.datapanel;

import main.vo.financevo.StatementVO;

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
        this.setSize(830, receiptPanel.getHeight() + payPanel.getHeight() + 20);
    }

    private void initPanel() {
        receiptPanel = new ReceiptPanel(statementVO.receiptBillVOs);
        receiptPanel.setLocation(0, 0);

        payPanel = new PayPanel(statementVO.payBillVOs);
        payPanel.setLocation(0, receiptPanel.getHeight() + 10);

        this.add(receiptPanel);
        this.add(payPanel);
    }
}
