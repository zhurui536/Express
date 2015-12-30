package presentation.strategyui.datapanel;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.City;
import vo.DistanceVO;


@SuppressWarnings("serial")
public class ConstantStrategyShowPane extends JPanel {
	public ConstantStrategyShowPane(ArrayList<DistanceVO> distances, double price){
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		this.initialize(price, distances);
	}
	
	private void initialize(double price, ArrayList<DistanceVO> distances){
		JLabel pricenow = new JLabel("当前价格："+price);
		pricenow.setBounds(30, 20, 300, 40);
		this.add(pricenow);
		
		JLabel distancenow = new JLabel("当前距离显示：");
		distancenow.setBounds(30, 70, 140, 30);
		
		JTable table = new JTable(this.votostrings(distances), headers){
			public boolean isCellEditable(int row, int column) {
				 return false;
				 }
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(810, 30));
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(410);
		table.setShowGrid(true);
		table.setLocation(0, 0);
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 100, 810, 400);
		
		this.add(scroller);
	}
	
	private String[][] votostrings(ArrayList<DistanceVO> distances){
		String[][] result = new String[distances.size()][3];
		
		for(int i=0;i<distances.size();i++){
			result[i][0] = City.cityToString(distances.get(i).getCityA());
			result[i][1] = City.cityToString(distances.get(i).getCityB());
			result[i][2] = distances.get(i).getDistance()+"";
		}
		
		return result;
	}
	
	private final String[] headers = {"城市1", "城市2", "距离"};
}
