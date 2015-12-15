package presentation.billui.datapanel;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import po.logisticpo.ReceiptBillPO;
import vo.logisticvo.ReceiptBillVO;
import vo.logisticvo.ReceiptLineItemVO;

public class ReceiptBillDataPane extends JPanel {
//	public static void main(String[] args){
//		JFrame test = new JFrame();
//		test.setLayout(null);
//		test.setBounds(100, 100, 1000, 600);
//		
//		String s = "栖霞区";
//		String name = "141250212";
//		List<ReceiptLineItemPO> list = new ArrayList<ReceiptLineItemPO>();
//		for(int i=0;i<16;i++){
//			ReceiptLineItemPO item = new ReceiptLineItemPO(s, name, new BigDecimal(100+i));
//			list.add(item);
//		}
//		
//		ReceiptBillPO po = new ReceiptBillPO(new Time(), new BigDecimal(1799), name, list, name, name);
//		ReceiptBillDataPane data = new ReceiptBillDataPane(po);
//		test.getContentPane().add(data);
//		test.setVisible(true);
//	}
	
	public ReceiptBillDataPane(ReceiptBillPO po){
		ReceiptBillVO vo = po.poToVo();
		
		this.setLayout(null);
		this.setBounds(140, 100, 810, 500);
		
		this.initialize(vo);;
	}

	private void initialize(ReceiptBillVO vo) {
		List<ReceiptLineItemVO> items = vo.receiptLineItemVOs;
		
		Object[] columnname = {"列1", "列2", "列3", "列4"};
		Object[][] data = new Object[items.size()+3][4];
		data[0][0] = "机构id";
		data[0][1] = vo.institutionID;
		data[0][2] = "总金额";
		data[0][3] = vo.totalMoney;
		data[1][0] = "收款时间";
		data[1][1] = vo.time.toString();
		data[2][0] = "序号";
		data[2][1] = "快递员编号";
		data[2][2] = "barcode";
		data[2][3] = "金额";
		
		for(int i=0;i<items.size();i++){
			data[3+i][0] = i+1;
			data[3+i][1] = items.get(i).deliveryManID;
			data[3+i][2] = items.get(i).barCode;
			data[3+i][3] = items.get(i).money;
		}
		
		JTable table = new JTable(data, columnname){
			public boolean isCellEditable(int row, int column) {
				 return false;
				 }
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(810, 30));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.setShowGrid(true);
		table.setLocation(0, 0);
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
}
