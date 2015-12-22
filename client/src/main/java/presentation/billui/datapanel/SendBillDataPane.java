package presentation.billui.datapanel;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import po.logisticpo.SendBillPO;
import vo.logisticvo.SendBillVO;
import util.ExpressType;
import util.PackageType;

public class SendBillDataPane extends JPanel {
	public SendBillDataPane(SendBillPO po){
		SendBillVO vo = po.poToVo();
		
		this.setLayout(null);
		this.setBounds(140, 100, 810, 500);
		
		this.initialize(vo);
	}

	private void initialize(SendBillVO vo) {
		Object[] columnname = {"列1", "列2", "列3", "列4"};
		Object[][] rowdata = new Object[10][4];
		
		rowdata[0][0] = "快递员编号";
		rowdata[0][1] = vo.deliveryManID;
		rowdata[0][2] = "订单编号";
		rowdata[0][3] = vo.id;
		
		rowdata[1][0] = "货物名称";
		rowdata[1][1] = vo.goodsVO.name;
		rowdata[1][2] = "快递类型";
		rowdata[1][3] = ExpressType.typeToString(vo.goodsVO.expressType);
		
		rowdata[2][0] = "出发地";
		rowdata[2][1] = vo.goodsVO.departurePlace;
		rowdata[2][2] = "目的地";
		rowdata[2][3] = vo.goodsVO.destination;
		
		rowdata[3][0] = "货物体积";
		rowdata[3][1] = vo.goodsVO.volume;
		rowdata[3][2] = "货物重量";
		rowdata[3][3] = vo.goodsVO.weight;
		
		rowdata[4][0] = "包装类型";
		rowdata[4][1] = PackageType.typeToString(vo.goodsVO.packageType);
		rowdata[4][2] = "金额";
		rowdata[4][3] = vo.goodsVO.price;
		
		rowdata[5][0] = "出发时间";
		rowdata[5][1] = vo.goodsVO.startTime.toString();
		rowdata[5][2] = "接收时间";
		if(vo.goodsVO.receiveTime!=null){
			rowdata[5][3] = vo.goodsVO.receiveTime.toString();
		}
		else{
			rowdata[5][3] = "未接收";
		}
		
		rowdata[6][0] = "寄件人姓名";
		rowdata[6][1] = vo.senderVO.name;
		rowdata[6][2] = "寄件人住址";
		rowdata[6][3] = vo.senderVO.location;
		
		rowdata[7][0] = "寄件人单位";
		rowdata[7][1] = vo.senderVO.institution;
		rowdata[7][2] = "寄件人手机";
		rowdata[7][3] = vo.senderVO.mobliephoneNum;
		
		rowdata[8][0] = "收件人姓名";
		rowdata[8][1] = vo.senderVO.name;
		rowdata[8][2] = "收件人住址";
		rowdata[8][3] = vo.recipientVO.location;
		
		rowdata[9][0] = "收件人单位";
		rowdata[9][1] = vo.recipientVO.institution;
		rowdata[9][2] = "收件人手机";
		rowdata[9][3] = vo.recipientVO.mobliephoneNum;
		
		JTable table = new JTable(rowdata, columnname){
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
