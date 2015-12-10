package presentation.billui.tool;


import presentation.billui.listener.BillJudgeToolListener;
import presentation.storeui.tool.GetButtonOfTool;

import javax.swing.*;

@SuppressWarnings("serial")
public class BillJudgeTool extends JPanel implements GetButtonOfTool {
	private JButton[] buttons = new JButton[3];
	
	public BillJudgeTool(BillJudgeToolListener tl){
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		
		buttons[0] = new JButton("全部审批");
		buttons[0].setSize(105, 25);
		buttons[0].setLocation(145, 40);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("返回");
		buttons[1].setSize(100, 30);
		buttons[1].setLocation(880, 35);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2] = new JButton("单据刷新");
		buttons[2].setSize(105, 25);
		buttons[2].setLocation(300, 40);
		buttons[2].addActionListener(tl);
		this.add(buttons[2]);
	}

	@Override
	public JButton getButton(int i) {
		return buttons[i];
	}

	@Override
	public int getNumOfButton() {
		return buttons.length;
	}

}
