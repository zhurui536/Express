package presentation.storeui.datapanel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import po.storepo.InStoreBillPO;
import po.storepo.OutStoreBillPO;
import util.BillState;
import util.MyJTable;

@SuppressWarnings("serial")
public class StoreBillListPane extends JPanel {
	
	public StoreBillListPane(ArrayList<InStoreBillPO> bills){
		this.setLayout(null);
		this.setBounds(0, 0, 810, 500);
		
		Object[] columnnames = {"单据编号", "编写者id", "提交时间", "审批状态"};
		Object[][] rowdata = new Object[bills.size()][4];
		
		for(int i=0;i<bills.size();i++){
			rowdata[i][0] = bills.get(i).getBillID();
			rowdata[i][1] = bills.get(i).getUserID();
			rowdata[i][2] = df.format(bills.get(i).getGenerateTime().getTime());
			rowdata[i][3] = BillState.billStateToString(bills.get(i).getState());
		}
		
		MyJTable table = new MyJTable(rowdata, columnnames);
		table.setWidth(new int[]{200, 200, 200, 200});
		
		JScrollPane data = new JScrollPane(table);
		data.setBounds(0, 0, 810, 500);
		this.add(data);
	}
	
	public StoreBillListPane(ArrayList<OutStoreBillPO> bills, int x){
		this.setLayout(null);
		this.setBounds(0, 0, 810, 500);
		
		Object[] columnnames = {"单据编号", "编写者id", "提交时间", "审批状态"};
		Object[][] rowdata = new Object[bills.size()][4];
		
		for(int i=0;i<bills.size();i++){
			rowdata[i][0] = bills.get(i).getBillID();
			rowdata[i][1] = bills.get(i).getUserID();
			rowdata[i][2] = df.format(bills.get(i).getGenerateTime().getTime());
			rowdata[i][3] = BillState.billStateToString(bills.get(i).getState());
		}
		
		MyJTable table = new MyJTable(rowdata, columnnames);
		table.setWidth(new int[]{200, 200, 200, 200});
		
		JScrollPane data = new JScrollPane(table);
		data.setBounds(0, 0, 810, 500);
		this.add(data);
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
}
