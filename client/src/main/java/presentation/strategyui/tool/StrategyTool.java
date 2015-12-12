package presentation.strategyui.tool;

import bussinesslogic.strategybl.StrategyConstantBLServiceImpl;
import bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import presentation.ToolPane;
import presentation.managerui.ManagerFrame;
import presentation.strategyui.datapanel.ConstantStrategyDataPane;
import presentation.strategyui.datapanel.ConstantStrategyShowPane;
import util.ResultMessage;
import vo.DistanceVO;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class StrategyTool extends ToolPane implements ActionListener {
	private JButton check;
	private JButton input;
	private JButton back;
	
	private ManagerFrame ui;
	private StrategyConstantBLService bl;
	
	public StrategyTool(ManagerFrame ui){
		this.ui = ui;
		bl = new StrategyConstantBLServiceImpl();
		
		this.initialize();
	}
	
	private void initialize(){
		check = new JButton("当前城市距离");
		check.setBounds(150, 20, 130, 40);
		check.addActionListener(this);
		this.add(check);
		
		input = new JButton("距离制定");
		input.setBounds(300, 20, 110, 40);
		input.addActionListener(this);
		this.add(input);
		
		back = new JButton("返回");
		back.setBounds(720, 20, 80, 40);
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
			ui.paintdata(null);
		}
	}
}
