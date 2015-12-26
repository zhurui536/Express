package presentation.strategyui.listener;

import bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import presentation.WarningDialog;
import presentation.mainui.ToolPane;
import presentation.managerui.ManagerFrame;
import presentation.storeui.listener.ToolListener;
import presentation.strategyui.datapanel.ConstantStrategyShowPane;
import presentation.strategyui.inputframe.DistanceInputFrame;
import presentation.strategyui.inputframe.PriceInputFrame;
import util.City;
import util.ResultMessage;
import vo.DistanceVO;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class StrategyToolListener extends ToolListener {
	private ManagerFrame ui;
	private StrategyConstantBLService bl;
	
	private DistanceInputFrame inputframe;
	
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
		
		if(i==0){//点击了城市距离制定
			inputframe = new DistanceInputFrame(this);
			inputframe.setVisible(true);
		}
		if(i==1){
			ResultMessage result = bl.getPrice();
			if(result.getKey().equals("success")){
				double price = (double) result.getValue();
				PriceInputFrame frame = new PriceInputFrame(price, this);
				frame.setVisible(true);
			}
		}
		if(i==2){//点击了城市距离查看
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
		if(i==3){//点击了返回
			ui.paintdata(null);
			ui.replaceTool(null);
		}
	}
	
	public boolean getInput(City a, City b, double distance){//输入框完成了输入及检查
		ResultMessage result = bl.inputDistanceInfo(new DistanceVO(a, b, distance));
		
		if(result.getKey().equals("success")){//修改成功，则显示新的信息
			ArrayList<DistanceVO> distances = (ArrayList<DistanceVO>) result.getValue();
			result = bl.getPrice();
			if(result.getKey().equals("success")){
				result = bl.getPrice();
				if(result.getKey().equals("success")){
					double price = (double) result.getValue();
					
					ConstantStrategyShowPane data = new ConstantStrategyShowPane(distances, price);
					ui.paintdata(data);
				}
				else{
					WarningDialog warning = new WarningDialog(ui, result.getKey());
				}
			}
		}
		return false;
	}
	
	public boolean getPriceInput(double price){
		ResultMessage result = bl.inputPriceInfo(price);
		if(result.getKey().equals("success")){
			return true;
		}
		WarningDialog warning = new WarningDialog(ui, result.getKey());
		return false;
	}
}
