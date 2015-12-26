package presentation.billui.datapanel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import po.logisticpo.ArrivalBillPO;
import util.MyJTable;
import vo.logisticvo.ArrivalBillVO;

@SuppressWarnings("serial")
public class ArrivalBillDataPane extends JPanel {
//	public static void main(String[] args){
//		JFrame test = new JFrame();
//		test.setLayout(null);
//		test.setBounds(200, 200, 1000, 600);
//		
//		ArrivalBillPO po = new ArrivalBillPO("栖霞区营业厅", "2015年12月13日", "141250212", "南京大学新老校区", GoodsState.COMPLETE);
//		test.add(new ArrivalBillDataPane(po));
//		
//		test.setVisible(true);
//	}
	
	public ArrivalBillDataPane(ArrivalBillPO po){
		ArrivalBillVO vo = new ArrivalBillVO(po);
		
		this.setLayout(null);
		this.setBounds(140, 100, 810, 500);
		
		this.initialize(vo);;
	}
	
	private void initialize(ArrivalBillVO vo){
		Object[] header = {"录入机构", "到达日期", "中转单编号", "出发地", "货物到达状态"};
		Object[][] rowdata = new Object[1][5];
		rowdata[0][0] = vo.institution;
		rowdata[0][1] = vo.date;
		rowdata[0][2] = vo.transferBillNum;
		rowdata[0][3] = vo.departurePlace;
		rowdata[0][4] = vo.goodsState.name();
		
		MyJTable table = new MyJTable(rowdata, header);
		table.setWidth(new int[]{160, 160, 160, 160, 160});
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
}
