package main.presentation.financeui.datapanel;

import main.vo.storevo.ProfitListVO;

import javax.swing.*;

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
        table.setRowHeight(60);
        table.setBounds(0, 0, 830, 60 * 2);

        for (int i = 0; i < row.length; i++) {
            table.setValueAt(row[i], 0, i);
        }

        table.setValueAt(profitListVO.income, 1, 0);
        table.setValueAt(profitListVO.pay, 1, 1);
        table.setValueAt(profitListVO.profit, 1, 2);
    }
}
