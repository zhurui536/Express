package presentation.billui.datapanel;

import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import po.financepo.PayBillPO;
import util.MyJTable;
import util.PayItem;
import util.Time;
import vo.financevo.PayBillVO;
//
@SuppressWarnings("serial")
public class PayBillDataPane extends JPanel {

	public static void main(String[] args){
		JFrame test = new JFrame();
		test.setBounds(100, 100, 1000, 600);

		PayBillPO po = new PayBillPO(new Time(), new BigDecimal(200), "141250212", "141250211", "785693057", PayItem.RENT, "测试用例");

		JPanel data = new PayBillDataPane(po);
		test.getContentPane().add(data);

		test.setVisible(true);
	}

	public PayBillDataPane(PayBillPO po){
		PayBillVO vo = po.poToVo();
		this.setLayout(null);
		this.setBounds(140, 100, 810, 500);

		this.initialize(vo, po.getUserID());
	}

	private void initialize(PayBillVO vo, String writerid){
		Object[] header = {"列1", "列2", "列3", "列4"};
		Object[][] rowdata = new Object[4][4];
		
		rowdata[0][0] = "付款单编写人";
		rowdata[0][1] = writerid;
		rowdata[0][2] = "付款单编号";
		rowdata[0][3] = vo.id;
		
		rowdata[1][0] = "付款人id";
		rowdata[1][1] = vo.staffID;
		rowdata[1][2] = "付款账号";
		rowdata[1][3] = vo.bankAccountID;
		
		rowdata[2][0] = "付款时间";
		rowdata[2][1] = vo.time.toString();
		rowdata[2][2] = "付款条目";
		rowdata[2][3] = vo.item.getName();
		
		rowdata[3][0] = "付款金额";
		rowdata[3][1] = vo.money;
		rowdata[3][2] = "备注";
		rowdata[3][3] = vo.remark;
		
		MyJTable table = new MyJTable(rowdata, header);
		table.setWidth(new int[]{200, 200, 200, 200});
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
}
