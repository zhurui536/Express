package main.presentation.strategyui.tool;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.bussinesslogic.strategybl.StrategyConstantBLServiceImpl;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import main.presentation.managerui.ManagerFrame;
import main.presentation.strategyui.datapanel.ConstantStrategyDataPane;
import main.presentation.strategyui.datapanel.ConstantStrategyShowPane;
import main.vo.DistanceVO;

@SuppressWarnings("serial")
public class StrategyTool extends JPanel implements ActionListener {
	private JButton check;
	private JButton input;
	private JButton back;
	
	private ManagerFrame ui;
	private StrategyConstantBLService bl;
	
	public StrategyTool(ManagerFrame ui){
		this.ui = ui;
		bl = new StrategyConstantBLServiceImpl();
		
		this.setName("instore");
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		this.setBackground(Color.BLUE);
		
		this.initialize();
	}
	
	private void initialize(){
		check = new JButton("当前策略查看");
		check.setBounds(150, 20, 110, 40);
		check.addActionListener(this);
		this.add(check);
		
		input = new JButton("策略制定");
		input.setBounds(300, 20, 110, 40);
		input.addActionListener(this);
		this.add(input);
		
		back = new JButton("返回");
		back.setBounds(750, 20, 50, 40);
		back.addActionListener(this);
		this.add(back);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == input){
			ConstantStrategyDataPane data = new ConstantStrategyDataPane(this.ui, bl);
			ui.paintdata(data);
		}
		if(e.getSource() == check){
			ArrayList<DistanceVO> distances = null;
			double price;
			ResultMessage result = bl.getPrice();
			if(result.getKey().equals("success")){
				price = (double) result.getValue();
				
				result = bl.getDistanceInfo();
				if(result.getKey().equals("success")){
					distances = (ArrayList<DistanceVO>) result.getValue();
					ConstantStrategyShowPane data = new ConstantStrategyShowPane(distances, price);
					ui.paintdata(data);
				}
				else{
					//提出警告
				}
			}
			else{
				//提出警告
			}
			
		}
		if(e.getSource() == back){
			ui.replaceTool(null);
		}
	}
}
