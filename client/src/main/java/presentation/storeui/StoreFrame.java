package presentation.storeui;

import bussinesslogic.storebl.StoreBLController;
import bussinesslogicservice.storeblservice.StoreBLService;
import connection.ClientInitException;
import presentation.storeui.listener.StoreMenuListener;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class StoreFrame extends JFrame{
	//处理窗口事件的对象
	private StoreBLService sc;
	
	//窗口中的成员组件，窗口分为菜单、工具和数据三个部分
	private JPanel menu;
	private StoreMenuListener menulistener;
	private JButton[] buttons;
	private JPanel tool;
	
	//由于data区可能有很多记录，所以添加了滑轮。。
	private JScrollPane scroll;
	private JPanel data;
	
	public StoreFrame(){
		this.setLayout(null);
		this.setSize(1000, 630);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menulistener = new StoreMenuListener(this);
		sc = new StoreBLController();
		this.paintframe();
	}
	
	public static void main(String[] args) throws ClientInitException{
		StoreFrame frame = new StoreFrame();
//		ClientRMIHelper.init();
		frame.setVisible(true);
	}
	
	private void paintframe(){
		paintmenu();
		painttool();
	}
	
	private void paintmenu(){
		menu = new JPanel();
		menu.setBackground(Color.RED);
		menu.setLayout(null);
		menu.setSize(140, 500);
		menu.setLocation(0, 100);
		
		buttons = new JButton[6];
		for(int i=0;i<6;i++){
			buttons[i] = createButton(i);
			buttons[i].setLocation(15, 35 + 75*i);
			menu.add(buttons[i], 0);
		}
		
		this.getContentPane().add(menu);;
	}
	
	private void painttool(){
		tool = new JPanel();
		tool.setLayout(null);
		tool.setSize(1000, 100);
		tool.setLocation(0, 0);
		tool.setBackground(Color.BLUE);
		
		this.getContentPane().add(tool);
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
	
	private JButton createButton(int i){
		JButton button = new JButton(names[i]);
		button.setSize(100, 35);
		button.addActionListener(menulistener);
		return button;
	}
	
	//方便监听者获得menu的按键，所以设置了这个方法
	public JButton getButton(int i){
		if(i>=buttons.length||i<0){
			return null;
		}
		
		return buttons[i];
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
	
	public void close(){
		if(tool == null){
			this.dispose();
			System.exit(0);
		}
	}
	
	public StoreBLService getController(){
		return this.sc;
	}
	
	private final String[] names = {"入库", "出库", "库存查看", "库存盘点", "库存调整", "退出"};
}
