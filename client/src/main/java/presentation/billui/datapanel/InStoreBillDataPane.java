package presentation.billui.datapanel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import po.storepo.InStoreBillPO;
import po.storepo.InStorePO;
import util.MyJTable;

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
		
		MyJTable table = new MyJTable(rowdata, columnnames);
		table.setWidth(new int[]{130, 50, 50, 50, 50, 200, 200});
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
}
