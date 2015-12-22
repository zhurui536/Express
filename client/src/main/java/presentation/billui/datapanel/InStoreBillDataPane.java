package presentation.billui.datapanel;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import po.storepo.InStoreBillPO;
import po.storepo.InStorePO;

@SuppressWarnings("serial")
public class InStoreBillDataPane extends JPanel {
	public InStoreBillDataPane(InStoreBillPO bill){
		String userid = bill.getUserID();
		String billid = bill.getBillID();
		ArrayList<InStorePO> pos = bill.getPOS();
//		InStoreVO list = new InStoreVO(pos);
		
		this.setLayout(null);
		
		Object[] columnnames = {"列1", "列2", "列3", "列4", "列5", "列6", "列7"};
		Object[][] rowdata = new Object[pos.size()+2][7];
		rowdata[0][0] = "入库单编写人";
		rowdata[0][1] = userid;
		rowdata[0][5] = "入库单编号";
		rowdata[0][6] = billid;
		rowdata[1][0] = "货物编号";
		rowdata[1][1] = "区号";
		rowdata[1][2] = "架号";
		rowdata[1][3] = "排号";
		rowdata[1][4] = "位号";
		rowdata[1][5] = "目的地";
		rowdata[1][6] = "入库日期";
		
		for(int i=0;i<pos.size();i++){
			rowdata[i+2][0] = pos.get(i).getGoodsID();
			rowdata[i+2][1] = pos.get(i).getStorePlace().getArea();
			rowdata[i+2][2] = pos.get(i).getStorePlace().getRow();
			rowdata[i+2][3] = pos.get(i).getStorePlace().getShelf();
			rowdata[i+2][4] = pos.get(i).getStorePlace().getPlace();
			rowdata[i+2][5] = pos.get(i).getDestination();
			rowdata[i+2][6] = df.format(pos.get(i).getDate().getTime());
		}
		
		JTable table = new JTable(rowdata, columnnames){
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
		
//		JPanel ids = new JPanel();
//		ids.setLayout(null);
//		ids.setBounds(10, 0, 800, 40);
//		
//		JLabel user = new JLabel("单据编写人：" + userid);
//		user.setBounds(0, 0, 250, 40);
//		ids.add(user);
//		
//		JLabel billID = new JLabel("单据编号：" + billid);
//		billID.setBounds(280, 0, 250, 40);
//		ids.add(billID);
//		
//		JPanel data = this.makedata(list);
//		data.setLocation(10, 40);
//		
//		this.setBounds(140, 100, 830, ids.getHeight() + data.getHeight());
//	}
//	
//	private JPanel makedata(InStoreVO list){
//		ArrayList<int[]> place = list.getPlace();
//		ArrayList<String> destination = list.getDestination();
//		ArrayList<String> goodslist = list.getIDs();
//		
//		JPanel data = new JPanel();
//		data.setSize(810, goodslist.size()*40 + 40);
//		data.setLayout(null);
//		
//		//第一行放置对应的目录
//		JPanel type = new JPanel();
//		type.setSize(810, 40);
//		type.setLocation(0, 0);
//		type.setLayout(null);
//		 
//		 
//		JLabel number = new JLabel("货物编号");
//		number.setSize(150, 40);
//		number.setLocation(10, 0);
//		type.add(number);
//		 
//		JLabel[] places = new JLabel[4];
//		for(int i=0;i<4;i++){
//			places[i] = new JLabel(this.places[i]);
//			places[i].setSize(50, 40);
//			places[i].setLocation(260 + 50*i, 0);
//			type.add(places[i]);
//		}
//		 
//		JLabel dest = new JLabel("目的地");
//		dest.setSize(200, 40);
//		dest.setLocation(550, 0);
//		type.add(dest);
//		 
//		data.add(type);
//		 
//		//接着加入入库项
//		for(int i=0;i<goodslist.size();i++){
//			JPanel item = makeItem(goodslist.get(i), place.get(i), destination.get(i));
//			item.setLocation(10, 40*i + 40);
//			
//			if(i%2==1){
//				item.setBackground(Color.YELLOW);
//			}
//			else{
//				item.setBackground(Color.CYAN);
//			}
//			 
//			data.add(item);
//		}
//		
//		return data;
//	}
//	
//	//制作入库项的panel的方法
//	private JPanel makeItem(String id, int[] place, String destination){
//		JPanel item = new JPanel();
//		item.setSize(810, 40);
//		item.setLayout(null);
//		
//		//加入id
//		JLabel number = new JLabel(id);
//		number.setSize(150, 40);
//		number.setLocation(10, 0);
//		item.add(number);
//		
//		//加入存储位置
//		JLabel[] places = new JLabel[4];
//		for(int i=0;i<4;i++){
//			places[i] = new JLabel(place[i]+"");
//			places[i].setSize(50, 40);
//			places[i].setBackground(Color.PINK);
//			places[i].setLocation(230 + 50*i, 0);
//			item.add(places[i]);
//		}
//		
//		//加入目的地
//		JLabel dest = new JLabel(destination);
//		dest.setSize(200, 40);
//		dest.setLocation(530, 0);
//		item.add(dest);
//		
//		return item;
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private String[] places = {"区号", "排号", "架号", "位号"};
}
