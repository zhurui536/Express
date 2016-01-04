package presentation.financeui.datapanel;


import javax.swing.JPanel;
import javax.swing.JTable;

import vo.financevo.AccountVO;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class InitPanel extends JPanel {

    private String[] row = { "时间", "机构", "人员", "车辆", "库存", "银行账户" };

    private AccountVO accountVO;

    private JTable table;

    public InitPanel(AccountVO accountVO) {
        this.accountVO = accountVO;
        init();
    }

    private void init() {
        this.setLayout(null);
        createTable();
        this.add(table);
        this.setSize(830, 500);
    }

    private void createTable() {
        table = new JTable(2, row.length);
        table.setRowHeight(60);
        table.setBounds(0, 0, 830, 60 * 2);

        for (int i = 0; i < row.length; i++) {
            table.setValueAt(row[i], 0, i);
        }

        if (accountVO == null) {
            return;
        }

        table.setValueAt(accountVO.time, 1, 0);
        table.setValueAt(accountVO.institutionVO.id, 1, 1);
        table.setValueAt(accountVO.staffMessageVO.id, 1, 2);
        table.setValueAt(accountVO.truckMessageVO.id, 1, 3);
        table.setValueAt(accountVO.storeVO, 1, 4);
        table.setValueAt(accountVO.bankAccountVO.id, 1, 5);

    }
}
