package presentation.strategyui.tool;

import javax.swing.JButton;

import presentation.ToolPane;
import presentation.strategyui.listener.SalaryToolListener;

public class SalaryTool extends ToolPane {
	private SalaryToolListener tl;
	
	public SalaryTool(SalaryToolListener tl){
		super.buttons = new JButton[3];
		this.tl = tl;
		
		this.initialize();
	}
	
	private void initialize(){
		buttons[0] = new JButton("当前薪水查看");
		buttons[0].setBounds(300, 20, 120, 40);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("确定");
		buttons[1].setBounds(620, 20, 80, 40);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2] = new JButton("返回");
		buttons[2].setBounds(720, 20, 80, 40);
		buttons[2].addActionListener(tl);
		this.add(buttons[2]);
	}
}
