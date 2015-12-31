package presentation.financeui.datapanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import presentation.mainui.component.MenuButton;
import vo.financevo.StatementVO;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class StatementPanel extends JPanel {
    
    private ReceiptPanel receiptPanel;
    
    private PayPanel payPanel;
       
    public StatementPanel(StatementVO statementVO) {
        receiptPanel = new ReceiptPanel(statementVO.receiptBillVOs);
        payPanel = new PayPanel(statementVO.payBillVOs);
        this.setLayout(null);
        initPanel();
        this.setSize(1000, 830);
    }

    private void initPanel() {
        JButton receipt = new MenuButton(0, 0, "收款单");
        JButton pay = new MenuButton(140, 0, "付款单");
        
        receiptPanel.setBounds(0, 60, 1000, 860);
        payPanel.setBounds(0, 60, 1000, 860);
        receipt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				payPanel.setVisible(false);
				receiptPanel.setVisible(true);
			}
		});
        
        pay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				receiptPanel.setVisible(false);
				payPanel.setVisible(true);
			}
		});
        
        this.add(receipt);
        this.add(pay);
        this.add(receiptPanel);
        this.add(payPanel);
        
        receiptPanel.setVisible(false);
        payPanel.setVisible(false);
    }
    
    public JTable getPayTable() {
    	return payPanel.getTable();
    }
    
    public JTable getReceiptTable() {
    	return receiptPanel.getTable();
    }
}
