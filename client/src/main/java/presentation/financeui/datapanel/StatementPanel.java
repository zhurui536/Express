package presentation.financeui.datapanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    
    private JScrollPane scrollPane;
    
    public StatementPanel(StatementVO statementVO) {
        receiptPanel = new ReceiptPanel(statementVO.receiptBillVOs);
        payPanel = new PayPanel(statementVO.payBillVOs);
        scrollPane = new JScrollPane();
        this.setLayout(null);
        initPanel();
        this.setSize(1000, 830);
    }

    private void initPanel() {
        JButton receipt = new MenuButton(0, 0, "收款单");
        JButton pay = new MenuButton(140, 0, "付款单");
        
        scrollPane.setBounds(0, 50, 1000, 860);
        scrollPane.setOpaque(false);
        
        receipt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(receiptPanel);
				repaint();
			}
		});
        
        pay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(payPanel);
				repaint();
			}
		});
        
        this.add(receipt);
        this.add(pay);
        this.add(scrollPane, 0);
    }
    
    public JTable getPayTable() {
    	return payPanel.getTable();
    }
    
    public JTable getReceiptTable() {
    	return receiptPanel.getTable();
    }
}
