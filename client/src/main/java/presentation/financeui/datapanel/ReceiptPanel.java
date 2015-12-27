package presentation.financeui.datapanel;

import vo.financevo.PayBillVO;
import vo.logisticvo.ReceiptBillVO;
import vo.logisticvo.ReceiptLineItemVO;

import javax.swing.*;

import util.MyFormat;
import util.MyJTable;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ReceiptPanel extends JPanel {

    private String[] header = { "收款时间", "收款单编号", "营业厅编号", "快递员编号", "订单条形码号", "收款金额" };

    private List<ReceiptBillVO> receiptBillVOs;

    private JTable table;

    public ReceiptPanel(List<ReceiptBillVO> receiptBillVOs) {
        this.receiptBillVOs = receiptBillVOs;
        init();
    }

    private void init() {
        this.setLayout(null);
        createTable();
        JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 830, 500);
		this.add(scroller);
        this.setSize(830, table.getHeight());
    }
    
    /**
     * 新建JTable
     */
    private void createTable() {
    	
    	int len = 0;
    	for (ReceiptBillVO receiptBillVO : receiptBillVOs) {
    		List<ReceiptLineItemVO> receiptLineItemVOs = receiptBillVO.receiptLineItemVOs;
    		len += receiptLineItemVOs.size();
    	}
    	
        Object[][] value = new Object[len + 2][6];
        int[] width = new int[] { 130, 150, 100, 120, 120, 150, 90 };
        
        len = 0;
        for (ReceiptBillVO receiptBillVO : receiptBillVOs) {
        	List<ReceiptLineItemVO> receiptLineItemVOs = receiptBillVO.receiptLineItemVOs;
        	for (ReceiptLineItemVO receiptLineItemVO : receiptLineItemVOs) {
        		value[len][1] = receiptBillVO.time.toString();
        		value[len][2] = receiptBillVO.billID;
        		value[len][3] = receiptBillVO.institutionID;
        		value[len][4] = receiptLineItemVO.deliveryManID;
        		value[len][5] = receiptLineItemVO.barCode;
        		value[len][6] = MyFormat.setFormat(receiptLineItemVO.money);
        		len++;
        	}
        }
         
        value[len + 1][0] = "总额";
        BigDecimal sum = BigDecimal.ZERO;
        for (ReceiptBillVO receiptBillVO : receiptBillVOs) {
            sum = sum.add(receiptBillVO.totalMoney);
        }
        table.setValueAt(format.format(sum), len + 1, 5);
        
        table = new MyJTable(value, header, width);
        
        int len = 1;

        if (receiptBillVOs == null) {
            return;
        }

        

        
    }
}
