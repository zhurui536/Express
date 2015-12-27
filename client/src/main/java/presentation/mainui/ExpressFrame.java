package presentation.mainui;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import presentation.mainui.component.MenuButton;
import presentation.mainui.component.MyMenu;
import presentation.mainui.component.MyTool;
import util.UIImage;

@SuppressWarnings("serial")
public class ExpressFrame extends JFrame{
	//窗口中的成员组件，窗口分为菜单、工具和数据三个部分
	protected MyMenu menu;
	protected MyTool tool;
	
	//由于data区可能有很多记录，所以添加了滑轮。。
	protected JScrollPane scroll;
	protected JPanel data;
	
	public static void main(String[] args){
		ExpressFrame test = new ExpressFrame();
		test.setVisible(true);
	}
	
	public ExpressFrame(){
		this.setLayout(null);
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel bg = new JLabel();
		bg.setIcon(UIImage.BACKGROUND_FRAME);
		bg.setBounds(0, 0, 1000, 600);
		this.getContentPane().add(bg, -1);
	}
	
	protected void paintmenu(String[] buttons, ActionListener listener){
		menu = new MyMenu(buttons, listener);
		
		this.getContentPane().add(menu, 0);
	}
	
	protected void painttool(){
		tool = new MyTool(new String[0], null);
		
		this.getContentPane().add(tool, 0);
	}
	
	public void replaceTool(MyTool newtool){
		if(tool != null){
			this.remove(tool);
		}
		this.tool = newtool;
		
		if(newtool != null){
			this.getContentPane().add(tool, 0);
		}
		else{
			this.painttool();
			this.refreshMenu();
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
			scroll.setBounds(150, 100, 850, 500);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			data.setPreferredSize(new Dimension(data.getWidth(), data.getHeight()));
			this.add(scroll, 0);
		}
		
		this.validate();
		this.repaint();
	}
	
	public MenuButton getButton(int i){
		return this.menu.buttons[i];
	}
	
	public void refreshMenu(){
		menu.refreshButton();
	}
}
