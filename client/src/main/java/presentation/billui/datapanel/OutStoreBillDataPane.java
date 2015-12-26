package presentation.billui.datapanel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import po.storepo.OutStoreBillPO;
import po.storepo.OutStorePO;
import util.MyJTable;
import util.Trans;

public class OutStoreBillDataPane extends JPanel {
	public OutStoreBillDataPane(OutStoreBillPO bill){
		//先进行一些简单的数据处理，因为懒不想再写单据的VO了。。。
		String userid = bill.getUserID();
		String billid = bill.getBillID();
		ArrayList<OutStorePO> pos = bill.getPOS();
//		OutStoreVO vo = new OutStoreVO(pos);
		
		this.setLayout(null);
		
		Object[] columnnames = {"列1", "列2", "列3", "列4", "列5"};
		Object[][] rowdata = new Object[pos.size()+2][5];
		rowdata[0][0] = "单据编写人";
		rowdata[0][1] = userid;
		rowdata[0][2] = "单据编号";
		rowdata[0][3] = billid;
		
		rowdata[1][0] = "货物编号";
		rowdata[1][1] = "出库时间";
		rowdata[1][2] = "目的地";
		rowdata[1][3] = "装运方式";
		rowdata[1][4] = "中转单或汽运单编号";
		
		for(int i=0;i<pos.size();i++){
			rowdata[i+2][0] = pos.get(i).getUser();
			rowdata[i+2][1] = df.format(pos.get(i).getDate().getTime());
			rowdata[i+2][2] = pos.get(i).getDestination();
			rowdata[i+2][3] = Trans.transToString(pos.get(i).getTrans());
			rowdata[i+2][4] = pos.get(i).getBillid();
		}
		
		MyJTable table = new MyJTable(rowdata, columnnames);
		table.setWidth(new int[]{150, 120, 200, 100, 150});
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
}
