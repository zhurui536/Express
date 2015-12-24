package presentation.storeui.tool;

import javax.swing.JButton;

import presentation.mainui.ToolPane;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class AdjustTool extends ToolPane{
	
	public AdjustTool(ToolListener tl){
		super.buttons = new JButton[3];
		buttons[0] = new JButton("新建移动项");
		buttons[0].setSize(105, 25);
		buttons[0].setLocation(145, 40);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1]= new JButton("确定");
		buttons[1].setSize(100, 30);
		buttons[1].setLocation(770, 35);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2] = new JButton("取消调整");
		buttons[2].setSize(100, 30);
		buttons[2].setLocation(880, 35);
		buttons[2].addActionListener(tl);
		this.add(buttons[2]);
		
	}
}
