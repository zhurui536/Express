package presentation.financeui.datapanel;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.MyFormat;
import util.MyJTable;
import vo.financevo.PayBillVO;


/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class PayPanel extends JPanel {

    private String[] header = { "付款时间", "付款单编号", "付款人ID", "付款账号", "条目", "备注", "付款金额(元)" };

    private List<PayBillVO> payBillVOs;

    private JTable table;

    public PayPanel(List<PayBillVO> payBillVOs) {
        this.payBillVOs = payBillVOs;
        init();
    }

    private void init() {
        this.setLayout(null);
        createTable();
        JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 840, 500);
		this.add(scroller);
        this.setSize(840, table.getHeight());
    }

    private void createTable() {
    	int len = payBillVOs.size();
        Object[][] value = new Object[len + 2][7];
        int[] width = new int[] { 130, 150, 120, 120, 80, 150, 90 };
        
        for (int i = 0; i < len; i++) {
            PayBillVO payBillVO = payBillVOs.get(i);
            value[i][0] = payBillVO.time.toString();
            value[i][1] = payBillVO.id;
            value[i][2] = payBillVO.staffID;
            value[i][3] = payBillVO.bankAccountID;
            value[i][4] = payBillVO.item.getName();
            value[i][5] = payBillVO.remark;
            value[i][6] = payBillVO.money;
        }
         
        value[len + 1][0] = "总额";
        BigDecimal sum = BigDecimal.ZERO;
        for (PayBillVO payBillVO : payBillVOs) {
            sum = sum.add(payBillVO.money);
        }
        value[len + 1][6] = MyFormat.setFormat(sum);
        
        table = new MyJTable(value, header, width);
    }
    
    public JTable getTable() {
    	return table;
    }
}
