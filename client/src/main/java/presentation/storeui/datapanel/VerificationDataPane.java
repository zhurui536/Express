package presentation.storeui.datapanel;

import vo.storevo.VerificationVO;

import javax.swing.*;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


@SuppressWarnings("serial")
public class VerificationDataPane extends JPanel {
	private JTable table;
	
	public VerificationDataPane(VerificationVO store){
		this.setLayout(null);
		this.setSize(810, 500);
		this.makeTable(store);
	}
	
	private void makeTable(VerificationVO store){
		ArrayList<String> goodsid = store.getGoodsID();
		ArrayList<int[]> place = store.getStorePlace();
		ArrayList<Calendar> time = store.getDate();
		ArrayList<String> destination = store.getDestination();
		
		Object[] header = {"货物编号", "区号", "排号", "架号", "位号", "入库时间", "目的地"};
		Object[][] rowdata = new Object[goodsid.size()][7];
		
		for(int i=0;i<goodsid.size();i++){
			rowdata[i][0] = goodsid.get(i);
			int[] places = place.get(i);
			rowdata[i][1] = places[0];
			rowdata[i][2] = places[1];
			rowdata[i][3] = places[2];
			rowdata[i][4] = places[3];
			rowdata[i][5] = df.format(time.get(i).getTime());
			rowdata[i][6] = destination.get(i);
		}
		
		table = new JTable(rowdata, header){
			public boolean isCellEditable(int row, int column) {
				 return false;
				 }
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(810, 30));
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.setShowGrid(true);
		table.setLocation(0, 0);
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	public JTable getTable(){
		return this.table;
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
}
