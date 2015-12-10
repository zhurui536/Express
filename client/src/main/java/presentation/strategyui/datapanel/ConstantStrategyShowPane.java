package presentation.strategyui.datapanel;

import util.City;
import vo.DistanceVO;

import javax.swing.*;
import java.util.ArrayList;


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
		
		JTable table  = new JTable(this.votostrings(distances), this.headers);
		table.setBounds(30, 80, 600, distances.size()*60+60);
		table.setEnabled(false);
		this.add(table);
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
