package presentation.managerui;

import bussinesslogic.billbl.BillBLController;
import bussinesslogic.strategybl.StrategyConstantBLServiceImpl;
import bussinesslogic.strategybl.StrategySalaryBLServiceImpl;
import bussinesslogicservice.billblservice.BillBLService;
import bussinesslogicservice.strategyblservice.StrategyConstantBLService;
import bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import presentation.managerui.listener.MenuListener;

import javax.swing.*;

import connection.ClientInitException;
import connection.ClientRMIHelper;

import java.awt.*;

@SuppressWarnings("serial")
public class ManagerFrame extends JFrame {

	//窗口中的成员组件，窗口分为菜单、工具和数据三个部分
	private JPanel menu;
	private MenuListener menulistener;
	private JButton[] buttons;
	private JPanel tool;
	
	//由于data区可能有很多记录，所以添加了滑轮。。
	private JScrollPane scroll;
	private JPanel data;
	
	//处理逻辑的逻辑层接口
	private BillBLService bs;
	private StrategyConstantBLService cs;
	private StrategySalaryBLService ss;
	
	public static void main(String[] args) throws ClientInitException{
		ClientRMIHelper.init();
		ManagerFrame test = new ManagerFrame();
		test.setVisible(true);
	}
	
	public ManagerFrame(){
		this.setLayout(null);
		this.setSize(1000, 630);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menulistener = new MenuListener(this);
		bs = new BillBLController();
		cs = new StrategyConstantBLServiceImpl();
		ss = new StrategySalaryBLServiceImpl();
		this.paintFrame();
	}
	
	private void paintFrame(){
		paintMenu();
		paintTool();
	}
	
	private void paintMenu(){
		menu = new JPanel();
		menu.setBackground(Color.GREEN);
		menu.setLayout(null);
		menu.setSize(140, 500);
		menu.setLocation(0, 100);
		
		buttons = new JButton[8];
		for(int i=0;i<8;i++){
			buttons[i] = new JButton(this.buttonname[i]);
			buttons[i].setSize(100, 35);
			buttons[i].setBackground(Color.PINK);
			buttons[i].addActionListener(menulistener);
		}
		buttons[7].setBackground(Color.RED);
		
		JLabel[] list = new JLabel[3];
		for(int i=0;i<3;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setSize(80, 40);
		}
		
		//添加策略制定及其按钮
		list[0].setLocation(0, 10);
		menu.add(list[0]);
		buttons[0].setLocation(20, 55);
		menu.add(buttons[0]);
		buttons[1].setLocation(20, 95);
		menu.add(buttons[1]);
		
		//添加单据审批及按钮
		list[1].setLocation(0, 140);
		menu.add(list[1]);
		buttons[2].setLocation(20, 185);
		menu.add(buttons[2]);
		
		//添加机构管理及按钮
		list[2].setLocation(0, 230);
		menu.add(list[2]);
		for(int i=3;i<=6;i++){
			buttons[i].setLocation(20, 275+40*(i-3));
			menu.add(buttons[i]);
		}
		
		//添加退出键
		buttons[7].setLocation(20, 440);
		menu.add(buttons[7]);
		
		this.getContentPane().add(menu);
	}
	
	//tool的初始化方法，加个颜色占地方而已。。
	private void paintTool(){
		tool = new JPanel();
		tool.setLayout(null);
		tool.setSize(1000, 100);
		tool.setLocation(0, 0);
		tool.setBackground(Color.BLUE);
		
		this.getContentPane().add(tool);
	}
	
	//由于menu发生点击事件时需要更换Tool区，故设置了这个方法
	public void replaceTool(JPanel newtool){
		if(this.tool != null){
			this.remove(tool);	
		}
		
		this.tool = newtool;
		
		if(newtool != null){
			tool.setBackground(Color.BLUE);
			this.getContentPane().add(tool);
		}
		this.validate();
		this.repaint();
	}
	
	//由于data区可能会经常更换，所以设置了这个方法
	public void paintdata(JPanel data){
		if(scroll != null){
			this.remove(scroll);
			scroll = null;
		}
		
		this.data = data;
		
		if(data != null){
			scroll = new JScrollPane(this.data);
			scroll.setBounds(150, 100, 830, 500);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			data.setPreferredSize(new Dimension(data.getWidth(), data.getHeight()));
			this.add(scroll);
		}
		
		this.validate();
		this.repaint();
	}
	
	//方便监听者获得menu的按键，所以设置了这个方法
	public JButton getButton(int i){
		return buttons[i];
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
	//点击退出键时的方法
	public void close(){
		this.dispose();
		System.exit(0);
	}
	
	private final String[] buttonname = {"运费策略制定", "薪水策略制定", "单据审批", "新增机构", "删除机构", "查看机构信息", "修改机构信息", "退出"};
	private final String[] listname = {"策略制定", "单据审批", "机构管理"};
}
