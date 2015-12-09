package main.presentation.strategyui.datapanel;

import java.util.ArrayList;

import javax.swing.JPanel;

import main.vo.DistanceVO;

@SuppressWarnings("serial")
public class ConstantStrategyShowPane extends JPanel {
	public ConstantStrategyShowPane(ArrayList<DistanceVO> distances, double price){
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		this.initialize();
	}
	
	private void initialize(){
		
	}
}
