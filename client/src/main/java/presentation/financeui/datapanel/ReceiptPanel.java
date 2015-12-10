package presentation.financeui.datapanel;

import vo.logisticvo.ReceiptBillVO;
import vo.logisticvo.ReceiptLineItemVO;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ReceiptPanel extends JPanel {

    private String[] row = { "收款时间", "营业厅编号", "快递员编号", "订单条形码号", "收款金额" };

    private List<ReceiptBillVO> receiptBillVOs;

    private JTable table;

    public ReceiptPanel(List<ReceiptBillVO> receiptBillVOs) {
        this.receiptBillVOs = receiptBillVOs;
        init();
    }

    private void init() {
        this.setLayout(null);
        createTable();
        this.add(table);
        this.setSize(830, table.getHeight());
    }

    private void createTable() {
        int numOfRow = 3;
        for (ReceiptBillVO receiptBillVO : receiptBillVOs) {
            List<ReceiptLineItemVO> receiptLineItemVOs = receiptBillVO.receiptLineItemVOs;
            numOfRow += receiptLineItemVOs.size();
        }

        table = new JTable(numOfRow, row.length);
        table.setRowHeight(60);
        table.setBounds(0, 0, 830, 60 * numOfRow);

        for (int i = 0; i < row.length; i++) {
            table.setValueAt(row[i], 0, i);
        }

        table.setValueAt("总额", numOfRow - 1, 0);

        int len = 1;

        if (receiptBillVOs == null) {
            return;
        }

        for (ReceiptBillVO receiptBillVO : receiptBillVOs) {
            List<ReceiptLineItemVO> receiptLineItemVOs = receiptBillVO.receiptLineItemVOs;

            if (receiptLineItemVOs == null) {
                return;
            }

            for (ReceiptLineItemVO receiptLineItemVO : receiptLineItemVOs) {
                table.setValueAt(receiptBillVO.time.toString(), len, 0);
                table.setValueAt(receiptBillVO.institutionID, len, 1);
                table.setValueAt(receiptLineItemVO.deliveryManID, len, 2);
                table.setValueAt(receiptLineItemVO.barCode, len, 3);
                table.setValueAt(receiptLineItemVO.money, len, 4);
                len++;
            }

        }

        BigDecimal sum = BigDecimal.ZERO;
        for (ReceiptBillVO receiptBillVO : receiptBillVOs) {
            sum = sum.add(receiptBillVO.totalMoney);
        }
        table.setValueAt(sum, len + 1, 4);
    }
}