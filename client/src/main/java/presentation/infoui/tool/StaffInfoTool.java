package presentation.infoui.tool;

import javax.swing.JButton;

import presentation.mainui.ToolPane;
import presentation.infoui.listener.StaffInfoToolListener;

public class StaffInfoTool extends ToolPane {
	
	public StaffInfoTool(StaffInfoToolListener tl){
		super.buttons = new JButton[5];
		
		buttons[0] = new JButton("当前信息查看");
		buttons[0].setBounds(145, 30, 120, 35);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("新增员工");
		buttons[1].setBounds(280, 30, 100, 35);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2] = new JButton("删除员工");
		buttons[2].setBounds(390, 30, 100, 35);
		buttons[2].addActionListener(tl);
		this.add(buttons[2]);
		
		buttons[3] = new JButton("修改员工信息");
		buttons[3].setBounds(500, 30, 120, 35);
		buttons[3].addActionListener(tl);
		this.add(buttons[3]);
		
		buttons[4] = new JButton("返回");
		buttons[4].setBounds(880, 30, 100, 35);
		buttons[4].addActionListener(tl);
		this.add(buttons[4]);
	}
}
