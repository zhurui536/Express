package main.presentation.storeui.tool;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.presentation.storeui.listener.ToolListener;

public class InStoreTool extends JPanel implements GetButtonOfTool{
	private JButton buttons[] = new JButton[4];
	
	public InStoreTool(ToolListener tl){
		this.setName("instore");
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		
		buttons[0] = new JButton("新建入库项");
		buttons[0].setSize(105, 25);
		buttons[0].setLocation(145, 40);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("删除入库项");
		buttons[1].setSize(105, 25);
		buttons[1].setLocation(265, 40);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2]= new JButton("确定");
		buttons[2].setSize(100, 30);
		buttons[2].setLocation(770, 35);
		buttons[2].addActionListener(tl);
		this.add(buttons[2]);
		
		buttons[3] = new JButton("取消入库");
		buttons[3].setSize(100, 30);
		buttons[3].setLocation(880, 35);
		buttons[3].addActionListener(tl);
		this.add(buttons[3]);
	}
	
	@Override
	public JButton getButton(int i){
		return buttons[i];
	}
}
