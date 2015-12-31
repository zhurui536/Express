package presentation.managerui;

import bussinesslogic.billbl.BillBLController;
import bussinesslogic.financebl.FinanceController;
import bussinesslogic.infobl.InfoBLController;
import bussinesslogic.strategybl.StrategyConstantBLServiceImpl;
import bussinesslogic.strategybl.StrategySalaryBLServiceImpl;
import bussinesslogicservice.billblservice.BillBLService;
import bussinesslogicservice.financeblservice.FinanceBLService;
import bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import presentation.mainui.ExpressFrame;
import presentation.managerui.listener.MenuListener;

@SuppressWarnings("serial")
public class ManagerFrame extends ExpressFrame {

	private MenuListener menulistener;
	
	//处理逻辑的逻辑层接口
	private BillBLService bs;
	private StrategyConstantBLService cs;
	private StrategySalaryBLService ss;
	private InfoBLController inf;
	private FinanceBLService fs;
	
	public static void main(String[] args){
//		ClientRMIHelper.init();
		ManagerFrame test = new ManagerFrame();
		test.setVisible(true);
	}
	
	public ManagerFrame(){
		menulistener = new MenuListener(this);
		bs = new BillBLController();
		cs = new StrategyConstantBLServiceImpl();
		ss = new StrategySalaryBLServiceImpl();
		inf = new InfoBLController();
		fs = new FinanceController();
		this.paintFrame();
	}
	
	private void paintFrame(){
		paintmenu(this.buttonname, this.menulistener);
		painttool();
	}
	
	//为了方便取得处理业务逻辑的对象，设置了此方法
	public BillBLService getBillBLController(){
		return this.bs;
	}
	
	public StrategyConstantBLService getStrategyBLController(){
		return this.cs;
	}
	
	public StrategySalaryBLService getStrategySalaryController(){
		return this.ss;
	}
	
	public InfoBLController getInfoController(){
		return this.inf;
	}
	
	public FinanceBLService getFinanceController(){
		return this.fs;
	}
	//点击退出键时的方法
	public void close(){
		this.dispose();
		System.exit(0);
	}
	
	private final String[] buttonname = {"运费制定", "薪水制定", "单据审批", "机构信息管理", "人员信息管理", "查看日志", "报表查看", "退出"};
}
