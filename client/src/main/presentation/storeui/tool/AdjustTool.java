package main.presentation.storeui.tool;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AdjustTool extends JPanel implements GetButtonOfTool{
	private JButton buttons[] = new JButton[4];
	
	public AdjustTool(){
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		
		buttons[0] = new JButton("新建移动项");
		buttons[0].setSize(105, 25);
		buttons[0].setLocation(145, 40);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("删除移动项");
		buttons[1].setSize(105, 25);
		buttons[1].setLocation(265, 40);
		this.add(buttons[1]);
		
		buttons[2]= new JButton("确定");
		buttons[2].setSize(100, 30);
		buttons[2].setLocation(770, 35);
		this.add(buttons[2]);
		
		buttons[3] = new JButton("取消调整");
		buttons[3].setSize(100, 30);
		buttons[3].setLocation(880, 35);
		this.add(buttons[3]);
	}
	
	@Override
	public JButton getButton(int i){
		return buttons[i];
	}
}
