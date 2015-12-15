package presentation.billui.datapanel;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import po.logisticpo.DeliveryBillPO;
import util.Time;
import vo.logisticvo.DeliveryBillVO;

public class DeliveryBillDataPane extends JPanel {
//	public static void main(String[] args){
//		JFrame test = new JFrame();
//		test.setLayout(null);
//		test.setBounds(100, 100, 1000, 600);
//		
//		ArrayList<String> ids = new ArrayList<String>();
//		for(int i=141250212;i<141250220;i++){
//			ids.add(i+"");
//		}
//		Time time = new Time();
//		
//		DeliveryBillPO po = new DeliveryBillPO(time, ids, "141250212");
//		
//		DeliveryBillDataPane data = new DeliveryBillDataPane(po);
//		data.setBackground(Color.blue);
//		test.getContentPane().add(data);
//		
//		test.setVisible(true);
//	}
	public DeliveryBillDataPane(DeliveryBillPO po){
		DeliveryBillVO vo = new DeliveryBillVO(po);
		
		this.setLayout(null);
		this.setBounds(140, 100, 810, 500);
		
		this.initialize(vo);
	}
	
	private void initialize(DeliveryBillVO vo){
		ArrayList<String> ids = vo.ids;
		Time time = vo.time;
		String deliverManId = vo.deliverManId;
		
		Object[][] rowdata = new Object[ids.size()+3][2];
		Object[] columnnames = {"列1", "列2"};
		
		rowdata[0][0] = "派送员";
		rowdata[0][1] = deliverManId;
		rowdata[1][0] = "派送时间";
		rowdata[1][1] = time.toString();
		rowdata[2][0] = "序号";
		rowdata[2][1] = "货物编号";
		
		for(int i=0;i<ids.size();i++){
			rowdata[i+3][0] = i;
			rowdata[i+3][1] = ids.get(i);
		}
		
		JTable table = new JTable(rowdata, columnnames){
			public boolean isCellEditable(int row, int column) {
				 return false;
				 }
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(810, 30));
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(510);
		table.setShowGrid(true);
		table.setLocation(0, 0);
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
}
