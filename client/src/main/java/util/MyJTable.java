package util;

import java.awt.Dimension;

import javax.swing.JTable;

public class MyJTable extends JTable {
	
	private static final long serialVersionUID = 6123433343860834496L;

	public MyJTable(Object[][] rowdata, Object[] header){
		super(rowdata, header);
		this.setAutoResizeMode(AUTO_RESIZE_OFF);
		this.setPreferredScrollableViewportSize(new Dimension(810, 30));
		this.setRowHeight(30);
		this.setShowGrid(true);
		this.setLocation(0, 0);
	}
	
	public MyJTable(Object[][] rowdata, Object[] header, int[] widths){
		this(rowdata, header);
		this.setWidth(widths);
	}
	
	public void setWidth(int[] widths){
		try{
			for(int i=0;i<widths.length;i++){
				this.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
