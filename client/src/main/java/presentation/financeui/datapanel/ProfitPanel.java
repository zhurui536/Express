package presentation.financeui.datapanel;


import vo.financevo.ProfitListVO;

import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ProfitPanel extends JPanel {

    private String[] row = { "总收入", "总支出", "总利润" };

    private ProfitListVO profitListVO;

    private JTable table;

    public ProfitPanel(ProfitListVO profitListVO) {
        this.profitListVO = profitListVO;
        init();
    }

    private void init() {
        this.setLayout(null);
        createTable();
        this.add(table);
        this.setSize(830, table.getHeight());
    }

    private void createTable() {
        table = new JTable(2, 3);
        table.setRowHeight(40);
        table.setBounds(0, 0, 830, 40 * 2);
        table.setShowGrid(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < row.length; i++) {
            table.setValueAt(row[i], 0, i);
        }

        DecimalFormat format = new DecimalFormat("0.00");
        table.setValueAt(format.format(profitListVO.income), 1, 0);
        table.setValueAt(format.format(profitListVO.pay), 1, 1);
        table.setValueAt(format.format(profitListVO.profit), 1, 2);
    }
}
