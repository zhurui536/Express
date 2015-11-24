package main.presentation.storeui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.presentation.storeui.listener.MenuListener;


public class StoreFrame extends JFrame{
	private JPanel menu;
	private JButton[] buttons;
	private JPanel tool;
	
	private JPanel data;
	private JScrollPane scroll;
	
	private MenuListener menulistener;
	
	public StoreFrame(){
		this.setLayout(null);
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menulistener = new MenuListener(this);
		this.paintframe();
	}
	
	public static void main(String[] args){
		StoreFrame frame = new StoreFrame();
		
		frame.setVisible(true);
	}
	
	private void paintframe(){
		paintmenu();
		painttool();
		paintdata();
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
	
	private void paintdata(){
		
		data = new JPanel();
		data.setLocation(0, 0);
		data.setLayout(null);
		data.setSize(860, 100);
		data.setBackground(Color.gray);
		scroll = new JScrollPane(data);
		scroll.setLocation(140, 100);
		scroll.setSize(860, 500);
		
		this.getContentPane().add(scroll);
	}
	
	private JButton createButton(int i){
		JButton button = new JButton(names[i]);
		button.setSize(100, 35);
		button.addActionListener(menulistener);
		return button;
	}
	
	public JButton getButton(int i){
		return buttons[i];
	}
	
	public void replaceTool(JPanel newtool){
		this.remove(tool);
		this.tool = newtool;
		this.getContentPane().add(tool);
		this.validate();
		this.repaint();
	}
	
	public void close(){
		
	}
	
	private final String[] names = {"入库", "出库", "库存查看", "库存盘点", "库存调整", "退出"};
}
