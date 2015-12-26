package util;

import java.awt.Dimension;

import javax.swing.JTable;

public class MyJTable extends JTable {
	
	public MyJTable(Object[][] rowdata, Object[] header){
		super(rowdata, header);
		this.setAutoResizeMode(AUTO_RESIZE_OFF);
		this.setPreferredScrollableViewportSize(new Dimension(810, 30));
		this.setRowHeight(30);
		this.setShowGrid(true);
		this.setLocation(0, 0);
	}
	
	public void setWidth(int[] widthes){
		try{
			for(int i=0;i<widthes.length;i++){
				this.getColumnModel().getColumn(i).setPreferredWidth(widthes[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
