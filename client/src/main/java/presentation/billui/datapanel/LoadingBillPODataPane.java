package presentation.billui.datapanel;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import po.logisticpo.LoadingBillPO;
import util.Time;
import vo.logisticvo.LoadingBillVO;

public class LoadingBillPODataPane extends JPanel {
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
//		String s = "141250212";
//		LoadingBillPO po = new LoadingBillPO(s, time, s, s, s, s, s, ids);
//		
//		LoadingBillPODataPane data = new LoadingBillPODataPane(po);
//		test.getContentPane().add(data);
//		
//		test.setVisible(true);
//	}
	public LoadingBillPODataPane(LoadingBillPO po){
		LoadingBillVO vo = new LoadingBillVO(po);
		
		this.setLayout(null);
		this.setBounds(140, 100, 810, 500);
		
		this.initialize(vo);
	}
	
	private void initialize(LoadingBillVO vo){
		String institution = vo.institution;
		Time date = vo.date;
		String transferNum = vo.transferNum;
		String arrivalPlace = vo.arrivalPlace;
		String numOfTruck = vo.numOfTruck;
		String supervisor = vo.supervisor;
		String supercargo = vo.supercargo;
		ArrayList<String> ids = vo.ids;
		double charge = vo.charge;
		
		Object[][] rowdata = new Object[ids.size()+9][2];
		Object[] columnnames = {"列1", "列2"};
		
		for(int i=0;i<listname.length;i++){
			rowdata[i][0] = listname[i];
		}
		rowdata[0][1] = institution;
		rowdata[1][1] = date.toString();
		rowdata[2][1] = transferNum;
		rowdata[3][1] = numOfTruck;
		rowdata[4][1] = supervisor;
		rowdata[5][1] = supercargo;
		rowdata[6][1] = arrivalPlace;
		rowdata[7][1] = charge;
		rowdata[8][0] = "序号";
		rowdata[8][1] = "货物编号";
		
		for(int i=0;i<ids.size();i++){
			rowdata[i+9][0] = i+1;
			rowdata[i+9][1] = ids.get(i);
		}
		
		JTable table = new JTable(rowdata, columnnames){
			public boolean isCellEditable(int row, int column) {
				 return false;
				 }
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(780, 30));
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(480);
		table.setShowGrid(true);
		table.setLocation(0, 0);
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	private String[] listname = {"机构id", "装车日期", "汽运编号", "车辆代号", "监装员", "押运员", "到达地", "运费" };
}
