package presentation.financeui.datapanel;


import vo.financevo.BankAccountVO;

import javax.swing.*;
import java.util.List;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountPanel extends JPanel {

    private String[] row = { "账号ID", "账号名称" , "余额" };

    private List<BankAccountVO> bankAccountVOs;

    private JTable table;

    public BankAccountPanel(List<BankAccountVO> bankAccountVOs) {
        this.bankAccountVOs = bankAccountVOs;
        init();
    }

    private void init() {
        this.setLayout(null);
        createTable();
        this.add(table);
        this.setSize(830, table.getHeight());
    }

    private void createTable() {
        int numOfRow = bankAccountVOs.size() + 1;
        table = new JTable(numOfRow, 3);
        table.setRowHeight(40);
        table.setBounds(0, 0, 830, 40 * numOfRow);
        table.setShowGrid(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < row.length; i++) {
            table.setValueAt(row[i], 0, i);
        }

        for (int i = 1; i < numOfRow; i++) {
            BankAccountVO bankAccountVO = bankAccountVOs.get(i - 1);
            table.setValueAt(bankAccountVO.id, i, 0);
            table.setValueAt(bankAccountVO.name, i, 1);
            table.setValueAt(bankAccountVO.balance, i, 2);
        }

    }

}
