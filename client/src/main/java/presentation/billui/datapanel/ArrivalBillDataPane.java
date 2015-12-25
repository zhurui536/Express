package presentation.billui.datapanel;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import po.logisticpo.ArrivalBillPO;
import vo.logisticvo.ArrivalBillVO;

@SuppressWarnings("serial")
public class ArrivalBillDataPane extends JPanel {
//	public static void main(String[] args){
//		JFrame test = new JFrame();
//		test.setLayout(null);
//		test.setBounds(400, 400, 1000, 600);
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
		
		JTable table = new JTable(rowdata, header){
			public boolean isCellEditable(int row, int column) {
				 return false;
				 }
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(810, 30));
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.getColumnModel().getColumn(4).setPreferredWidth(160);
		table.setShowGrid(true);
		table.setLocation(0, 0);
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	private final String[] listnames = { "录入机构", "到达日期", "中转单编号", "出发地", "货物到达状态"};
}
