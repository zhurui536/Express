//package main.presentation.financeui.datapanel;
//
//import main.vo.financevo.BankAccountVO;
//
//import javax.swing.*;
//import java.util.List;
//
///**
// * Created by Away
// * 2015/12/9
// */
//
//public class PayPanel extends JPanel {
//
//    private String[] row = { "付款人ID", "付款金额" , "付款账号", "条目", "备注" };
//
//    private List<BankAccountVO> bankAccountVOs;
//
//    private JTable table;
//
//    public BankAccountPanel(List<BankAccountVO> bankAccountVOs) {
//        this.bankAccountVOs = bankAccountVOs;
//        init();
//    }
//
//    private void init() {
//        this.setLayout(null);
//        createTable();
//        this.add(table);
//        this.setSize(830, table.getHeight());
//    }
//
//    private void createTable() {
//        int numOfRow = bankAccountVOs.size() + 1;
//        table = new JTable(numOfRow, 3);
//        table.setRowHeight(60);
//        table.setBounds(0, 0, 830, 60 * numOfRow);
//
//        for (int i = 0; i < row.length; i++) {
//            table.setValueAt(row[i], 0, i);
//        }
//
//        for (int i = 1; i < numOfRow; i++) {
//            BankAccountVO bankAccountVO = bankAccountVOs.get(i - 1);
//            table.setValueAt(bankAccountVO.id, i, 0);
//            table.setValueAt(bankAccountVO.name, i, 1);
//            table.setValueAt(bankAccountVO.balance, i, 2);
//        }
//
//    }
//}
