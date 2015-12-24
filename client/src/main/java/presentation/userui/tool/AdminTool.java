package presentation.userui.tool;

import javax.swing.JButton;

import presentation.mainui.ToolPane;
import presentation.userui.listener.AdminToolListener;

public class AdminTool extends ToolPane {
	
	public AdminTool(AdminToolListener tl){
		super.buttons = new JButton[3];
		
		buttons[0] = new JButton("新建用户");
		buttons[0].setBounds(145, 40, 105, 25);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("取消");
		buttons[1].setBounds(840, 40, 60, 25);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2] = new JButton("确定");
		buttons[2].setBounds(760, 40, 60, 25);
		buttons[2].addActionListener(tl);
		this.add(buttons[2]);
	}
}
