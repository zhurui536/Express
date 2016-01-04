package presentation.financeui.datapanel;


import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.MyJTable;
import vo.financevo.BankAccountVO;

/**
 * 银行账户显示 panel
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountPanel extends JPanel {

    private String[] header = { "账号ID", "账号名称" , "余额" };

    private List<BankAccountVO> bankAccountVOs;

    private JTable table;

    public BankAccountPanel(List<BankAccountVO> bankAccountVOs) {
        this.bankAccountVOs = bankAccountVOs;
        init();
    }

    private void init() {
        this.setLayout(null);
        createTable();
        this.setSize(830, 500);
    }
    
    /**
     * 创建JTable
     */
    private void createTable() {
    	int len = bankAccountVOs.size();
    	System.err.println(len);
        Object[][] value = new Object[len][3];
        int[] width = { 276, 276, 276 };
        for (int i = 0; i < len; i++) {
            BankAccountVO bankAccountVO = bankAccountVOs.get(i);
            value[i][0] = bankAccountVO.id;
            value[i][1] = bankAccountVO.name;
            value[i][2] = bankAccountVO.balance;
        }

        table = new MyJTable(value, header, width);
        
        JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 830, 500);
		
		this.add(scroller);
    }

}
