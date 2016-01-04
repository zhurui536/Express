package presentation.financeui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.FinanceFrame;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.ResultMessage;
import vo.financevo.BankAccountVO;

/**
 * 结算管理输入窗口
*/
@SuppressWarnings("serial")
public class SettleDialog extends InputFrame {
	
	// 收款账号
    private JComboBox<String> accountID;
    // 收款单ID
    private JComboBox<String> billID;
    private FinanceFrame ui;
    private FinanceBLService financeController;
    
    public SettleDialog(FinanceFrame ui) {
        super(ui);
        this.ui = ui;
        this.financeController = ui.getFinanceController();
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 250);
        this.setBackgroundSize(400, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = (JPanel) this.getContentPane();

        JButton ok = new ToolButton(150, 150,"确定");
        ok.setSize(100, 40);
        ok.addActionListener(new okListener());
        
        JLabel account = new JLabel("账户ID");
        account.setBounds(70, 30, 100, 50);
        
        accountID = new JComboBox<>();
        accountID.setBounds(170, 40, 100, 30);
        
        JLabel bill = new JLabel("收款单编号");
        bill.setBounds(70, 80, 100, 50);
        
        billID = new JComboBox<>();
        billID.setBounds(170, 90, 100, 30);
        
        initID();
        
        panel.setLayout(null);
        panel.add(ok, 0);
        panel.add(accountID, 0);
        panel.add(billID, 0);
        panel.add(account, 0);
        panel.add(bill, 0);
    }


	private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            initID();
            String id1 = (String) billID.getSelectedItem();
            String id2 = (String) accountID.getSelectedItem();
            financeController.settleReceipt(id1, id2);
        }

    }
	
	private void initID() {
		accountID.removeAllItems();
		billID.removeAllItems();
		List<String> accountIDs = getAccountID();
		List<String> billIDs = getBillID();
		for (String id : accountIDs) {
			accountID.addItem(id);
		}
		
		for(String id : billIDs) {
			billID.addItem(id);
		}		
	}
    
    @SuppressWarnings("unchecked")
    private List<String> getBillID() {
    	ResultMessage message = financeController.getUnSettledReceipt();
    	List<String> ids = (List<String>) message.getValue();
    	return ids;
    }
    
    @SuppressWarnings("unchecked")
    private List<String> getAccountID() {
    	ResultMessage message = financeController.showAllMember();
    	List<BankAccountVO> bankAccountVOs = (List<BankAccountVO>) message.getValue();
    	List<String> ids = new ArrayList<>();
    	for(BankAccountVO bankAccountVO : bankAccountVOs) {
    		ids.add(bankAccountVO.id);
    	}
    	return ids;
    }
}
