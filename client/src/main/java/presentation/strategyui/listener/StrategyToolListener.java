package presentation.strategyui.listener;

import bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import presentation.WarningDialog;
import presentation.mainui.ToolPane;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import presentation.strategyui.datapanel.ConstantStrategyDataPane;
import presentation.strategyui.datapanel.ConstantStrategyShowPane;
import util.ResultMessage;
import vo.DistanceVO;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class StrategyToolListener extends ToolListener {
	private ManagerFrame ui;
	private StrategyConstantBLService bl;
	
	public StrategyToolListener(ManagerFrame ui){
		this.ui = ui;
		bl = ui.getStrategyBLController();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ToolPane tool = super.getTool();
		
		int i=0;
		for(;i<tool.getNumOfButton();i++){
			if(arg0.getSource() == tool.getButton(i)){
				break;
			}
		}
		
		if(i==0){
			ConstantStrategyDataPane data = new ConstantStrategyDataPane(ui, bl);
			ui.paintdata(data);
		}
		if(i==1){
			ArrayList<DistanceVO> distances = null;
			double price = 0;
			
			ResultMessage result = bl.getDistanceInfo();
			if(result.getKey().equals("success")){
				distances = (ArrayList<DistanceVO>) result.getValue();
				result = bl.getPrice();
				if(result.getKey().equals("success")){
					price = (double) result.getValue();
					
					ConstantStrategyShowPane data = new ConstantStrategyShowPane(distances, price);
					ui.paintdata(data);
				}
				else{
					WarningDialog warning = new WarningDialog(ui, result.getKey());
				}
			}
			else{
				WarningDialog warning = new WarningDialog(ui, result.getKey());
			}
		}
		if(i==2){
			ui.paintdata(null);
			ui.replaceTool(null);
		}
	}
}
