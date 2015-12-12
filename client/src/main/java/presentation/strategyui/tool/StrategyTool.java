package presentation.strategyui.tool;

import bussinesslogic.strategybl.StrategyConstantBLServiceImpl;
import bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import presentation.ToolPane;
import presentation.managerui.ManagerFrame;
import presentation.strategyui.listener.StrategyToolListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class StrategyTool extends ToolPane {
	
	private ManagerFrame ui;
	private StrategyConstantBLService bl;
	private StrategyToolListener tl;
	
	public StrategyTool(ManagerFrame ui, StrategyToolListener tl){
		super.buttons = new JButton[2];
		this.ui = ui;
		this.tl = tl;
		bl = new StrategyConstantBLServiceImpl();
		
		this.initialize();
	}
	
	private void initialize(){
		buttons[0] = new JButton("距离制定");
		buttons[0].setBounds(300, 20, 110, 40);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("返回");
		buttons[1].setBounds(720, 20, 80, 40);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == input){
//			ConstantStrategyDataPane data = new ConstantStrategyDataPane(this.ui, bl);
//			ui.paintdata(data);
//		}
//		if(e.getSource() == check){
//			ArrayList<DistanceVO> distances = null;
//			double price;
//			ResultMessage result = bl.getPrice();
//			if(result.getKey().equals("success")){
//				price = (double) result.getValue();
//				
//				result = bl.getDistanceInfo();
//				if(result.getKey().equals("success")){
//					distances = (ArrayList<DistanceVO>) result.getValue();
//					ConstantStrategyShowPane data = new ConstantStrategyShowPane(distances, price);
//					ui.paintdata(data);
//				}
//				else{
//					//提出警告
//				}
//			}
//			else{
//				//提出警告
//			}
//			
//		}
//		if(e.getSource() == back){
//			ui.replaceTool(null);
//			ui.paintdata(null);
//		}
//	}
}
