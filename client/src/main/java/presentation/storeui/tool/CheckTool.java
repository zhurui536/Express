package presentation.storeui.tool;

import javax.swing.JButton;
import presentation.mainui.ToolPane;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class CheckTool extends ToolPane{
	
	public CheckTool(ToolListener tl){
		super.buttons = new JButton[2];
		
		buttons[0] = new JButton("search");
		buttons[0].setSize(100, 30);
		buttons[0].setLocation(770, 35);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("返回");
		buttons[1].setSize(100, 30);
		buttons[1].setLocation(880, 35);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
	}
	
}
