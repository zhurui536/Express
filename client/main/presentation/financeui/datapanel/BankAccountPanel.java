package main.presentation.financeui.datapanel;

import main.vo.financevo.BankAccountVO;

import javax.swing.*;
import java.util.List;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class BankAccountPanel extends JPanel {

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
    }

    private void createTable() {
        table = new JTable(2, 3);

    }

}
