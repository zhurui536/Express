package presentation.financeui.datapanel;

import vo.financevo.PayBillVO;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class PayPanel extends JPanel {

    private String[] row = { "付款人ID", "付款账号", "条目", "备注", "付款金额" };

    private List<PayBillVO> payBillVOs;

    private JTable table;

    public PayPanel(List<PayBillVO> payBillVOs) {
        this.payBillVOs = payBillVOs;
        init();
    }

    private void init() {
        this.setLayout(null);
        createTable();
        this.add(table);
        this.setSize(830, table.getHeight());
    }

    private void createTable() {
        int numOfRow = payBillVOs.size() + 3;
        table = new JTable(numOfRow, 5);
        table.setRowHeight(60);
        table.setBounds(0, 0, 830, 60 * numOfRow);

        for (int i = 0; i < row.length; i++) {
            table.setValueAt(row[i], 0, i);
        }

        for (int i = 1; i <= payBillVOs.size(); i++) {
            PayBillVO payBillVO = payBillVOs.get(i - 1);
            table.setValueAt(payBillVO.id, i, 0);
            table.setValueAt(payBillVO.bankAccountVO.id, i, 1);
            table.setValueAt(payBillVO.item.getName(), i, 2);
            table.setValueAt(payBillVO.remark, i, 3);
            table.setValueAt(payBillVO.money, i, 4);
        }

        int len = payBillVOs.size() + 2;
        table.setValueAt("总额", len, 0);
        BigDecimal sum = BigDecimal.ZERO;
        for (PayBillVO payBillVO : payBillVOs) {
            sum = sum.add(payBillVO.money);
        }
        table.setValueAt(sum, len, 4);
    }
}
