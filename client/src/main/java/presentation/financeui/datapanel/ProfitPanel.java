package presentation.financeui.datapanel;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.MyFormat;
import util.MyJTable;
import vo.financevo.ProfitListVO;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ProfitPanel extends JPanel {

    private String[] header = { "总收入", "总支出", "总利润" };

    private ProfitListVO profitListVO;

    private JTable table;

    public ProfitPanel(ProfitListVO profitListVO) {
        this.profitListVO = profitListVO;
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

    private void createTable() {
        Object[][] value = new Object[1][3];
        int[] width = new int[] { 270, 270, 270 };
   
        value[0][0] = MyFormat.setFormat(profitListVO.income);
        value[0][1] = MyFormat.setFormat(profitListVO.pay);
        value[0][2] = MyFormat.setFormat(profitListVO.profit);
        
        table = new MyJTable(value, header, width);
    }
}
