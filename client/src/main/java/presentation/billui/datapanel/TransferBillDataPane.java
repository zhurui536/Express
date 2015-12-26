package presentation.billui.datapanel;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import po.logisticpo.TransferBillPO;
import util.MyJTable;
import util.Trans;

public class TransferBillDataPane extends JPanel {
	public TransferBillDataPane(TransferBillPO po){
		this.setLayout(null);
		this.setBounds(140, 100, 810, 500);
		
		this.initialize(po);
	}
	
	private void initialize(TransferBillPO po){
		ArrayList<String> ids = po.getIds();
		int size = ids.size();
		
		if(size%2==1){
			size++;
		}
		Object[] columnname = {"列1", "列2", "列3", "列4"};
		Object[][] rowdata = new Object[6+size/2][4];
		
		rowdata[0][0] = "中转单编号";
		rowdata[0][1] = po.getTransferBillNum();
		rowdata[0][2] = "装车日期";
		rowdata[0][3] = po.getTime();
		
		rowdata[1][0] = "装运方式";
		rowdata[1][1] = Trans.transToString(po.getTrans());
		rowdata[1][2] = "运费";
		rowdata[1][3] = po.getCharge();
		
		rowdata[2][0] = "航班号/车次号";
		rowdata[2][1] = po.getNumber();
		rowdata[2][2] = "车厢号/货柜号";
		rowdata[2][3] = po.getNumOfLoc();
		
		rowdata[3][0] = "押运员";
		rowdata[3][1] = po.getSupercargo();
		rowdata[3][2] = "监装员";
		rowdata[3][3] = po.getSupervisor();
		
		rowdata[4][0] = "出发地";
		rowdata[4][1] = po.getDepaturePlace();
		rowdata[4][2] = "到达地";
		rowdata[4][3] = po.getArrivalPlace();
		
		rowdata[5][0] = "序号";
		rowdata[5][1] = "货物编号";
		rowdata[5][2] = "序号";
		rowdata[5][3] = "货物编号";
		
		for(int i=0;i<ids.size();i++){
			if(i%2==0){
				rowdata[6+i/2][0] = i+1;
				rowdata[6+i/2][1] = ids.get(i);
			}
			else{
				rowdata[6+i/2][2] = i+1;
				rowdata[6+i/2][3] = ids.get(i);
			}
		}
		
		MyJTable table = new MyJTable(rowdata, columnname);
		table.setWidth(new int[]{200, 200, 200, 200});
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
}
