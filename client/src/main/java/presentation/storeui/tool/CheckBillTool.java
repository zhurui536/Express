package presentation.storeui.tool;

import javax.swing.JButton;

import presentation.mainui.ToolPane;
import presentation.storeui.listener.ToolListener;

public class CheckBillTool extends ToolPane {
	
	public CheckBillTool(ToolListener tl){
		super.buttons = new JButton[3];
		
		buttons[0] = new JButton("查看入库单");
		buttons[0].setSize(105, 25);
		buttons[0].setLocation(145, 40);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("查看入库单");
		buttons[1].setSize(105, 25);
		buttons[1].setLocation(265, 40);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2] = new JButton("查看当前库存");
		buttons[2].setSize(105, 25);
		buttons[2].setLocation(380, 40);
		buttons[2].addActionListener(tl);
		this.add(buttons[2]);
		
		buttons[3] = new JButton("返回");
		buttons[3].setSize(105, 25);
		buttons[3].setLocation(145, 40);
		buttons[3].addActionListener(tl);
		this.add(buttons[3]);
	}
}
