package presentation.userui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import connection.ClientInitException;
import connection.ClientRMIHelper;
import bussinesslogic.adminbl.AdminBL;
import bussinesslogicservice.adminblservice.AdminBLService;
import presentation.userui.listener.AdminMenuListener;

public class AdminFrame extends JFrame {
	//处理用例逻辑的对象
	private AdminBLService bl;
	
	//窗口中的成员组件，窗口分为菜单、工具和数据三个部分
	private JPanel menu;
	private AdminMenuListener menulistener;
	private JButton[] buttons;
	private JPanel tool;
	
	//由于data区可能有很多记录，所以添加了滑轮。。
	private JScrollPane scroll;
	private JPanel data;
	
	public static void main(String[] args){
		
	        try {
	            ClientRMIHelper.init();
	        } catch (ClientInitException e) {
	            e.printStackTrace();
	        }
	    
		AdminFrame frame = new AdminFrame();
		frame.setVisible(true);
	}
	
	public AdminFrame(){
		this.setLayout(null);
		this.setSize(1000, 630);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bl = new AdminBL();
		this.paintFrame();
	}
	
	private void paintFrame(){
		this.paintMenu();
		this.paintTool();
	}
	
	private void paintMenu(){
		menulistener = new AdminMenuListener(this);
		
		menu = new JPanel();
		menu.setBackground(Color.RED);
		menu.setLayout(null);
		menu.setSize(140, 500);
		menu.setLocation(0, 100);
		
		buttons = new JButton[2];
		buttons[0] = new JButton("用户管理");
		buttons[0].setBounds(15, 35, 100, 35);
		buttons[0].addActionListener(menulistener);
		menu.add(buttons[0]);
		
		buttons[1] = new JButton("退出");
		buttons[1].setBounds(15, 430, 100, 35);
		buttons[1].addActionListener(menulistener);
		menu.add(buttons[1]);
		
		this.getContentPane().add(menu);
	}
	
	private void paintTool(){
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
	
	//为监听者获得按钮引用而设置的方法
	public JButton getButton(int i){
		if(i>=buttons.length||i<0){
			return null;
		}
		
		return buttons[i];
	}
	
	public AdminBLService getController(){
		return this.bl;
	}
}
