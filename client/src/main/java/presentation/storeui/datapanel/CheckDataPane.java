package presentation.storeui.datapanel;

import util.MyJTable;
import vo.storevo.CheckVO;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


@SuppressWarnings("serial")
public class CheckDataPane extends JPanel {
	
	public CheckDataPane(CheckVO vo){
		this.setBounds(0, 0, 860, 1000);
		this.setLayout(null);
		ArrayList<Calendar> timeOfIn = vo.getTimeOfIn();
		ArrayList<String> IDOfIn = vo.getIDOfIn();
		ArrayList<int[]> placeOfIn = vo.getPlaceOfIn();
		ArrayList<Calendar> timeOfOut = vo.getTimeOfOut();
		ArrayList<String> IDOfOut = vo.getIDOfOut();
		ArrayList<int[]> placeOfOut = vo.getPlaceOfOut();
		
		//合计部分的图块
		Object[] header = {"入库数量：", "出库数量：", "入库总金额：", "出库总金额：", "已用库存：", "空闲库存："};
		Object[][] rowdata = new Object[1][6];
		rowdata[0][0] = IDOfIn.size();
		rowdata[0][1] = IDOfOut.size();
		rowdata[0][2] = vo.getValueOfIn();
		rowdata[0][3] = vo.getValueOfOut();
		rowdata[0][4] = vo.getNumOfUsed();
		rowdata[0][5] = vo.getNumOfEmpty();
		
		MyJTable table = new MyJTable(rowdata, header);
		table.setWidth(new int[]{135, 135, 135, 135, 135, 135});
		
		JScrollPane total = new JScrollPane(table);
		total.setBounds(0, 0, 810, 60);
		this.add(total);
		
		this.inrecord(timeOfIn, placeOfIn, IDOfIn);
		this.outrecord(timeOfOut, placeOfOut, IDOfOut);
	}
	
	private void inrecord(ArrayList<Calendar> timeOfIn, ArrayList<int[]> placeOfIn, ArrayList<String> IDOfIn){
		//表头
		Object[] header = {"货物编号", "区", "排", "架", "位", "入库时间"};
		//构建表中的数据
		Object[][] rowdata = new Object[6][IDOfIn.size()];
		for(int i=0;i<IDOfIn.size();i++){
			//id
			rowdata[i][0] = IDOfIn.get(i);
			for(int j=1;j<5;j++){
				//存储位置
				int[] places = placeOfIn.get(i);
				rowdata[i][j] = places[j-1];
			}
			//时间
			rowdata[i][5] = df.format(timeOfIn.get(i).getTime());
		}
		
		MyJTable table = new MyJTable(rowdata, header);
		table.setWidth(new int[]{200, 100, 100, 100, 100, 200});
		
		JScrollPane data = new JScrollPane(table);
		data.setBounds(0, 65, 810, 420);
		this.add(data);
	}
	
	private void outrecord(ArrayList<Calendar> timeOfOut, ArrayList<int[]> placeOfOut, ArrayList<String> IDOfOut){
		//表头
		Object[] header = {"货物编号", "区", "排", "架", "位", "入库时间"};
		//构建表中的数据
		Object[][] rowdata = new Object[6][IDOfOut.size()];
		for(int i=0;i<IDOfOut.size();i++){
			rowdata[i][0] = IDOfOut.get(i);
			for(int j=1;j<5;j++){
				//存储位置
				int[] places = placeOfOut.get(i);
				rowdata[i][j] = places[j-1];
			}
			//时间
			rowdata[i][5] = df.format(timeOfOut.get(i).getTime());
		}
		
		MyJTable table = new MyJTable(rowdata, header);
		table.setWidth(new int[]{200, 100, 100, 100, 100, 200});
		
		JScrollPane data = new JScrollPane(table);
		data.setBounds(0, 490, 810, 420);
		this.add(data);
	}

	private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
}
