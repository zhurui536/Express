package main.presentation.storeui.tool;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.presentation.storeui.listener.ToolListener;

public class VerificationTool extends JPanel implements GetButtonOfTool{
	private JButton buttons[] = new JButton[2];
	
	public VerificationTool(ToolListener tl){
		this.setName("verification");
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		
		buttons[0] = new JButton("确定");
		buttons[0].setSize(100, 30);
		buttons[0].setLocation(770, 35);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("返回");
		buttons[1].setSize(100, 30);
		buttons[1].setLocation(880, 35);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		JLabel batch = new JLabel("批次：10010 批号：10086");
		batch.setSize(150, 60);
		batch.setLocation(145, 30);
		this.add(batch);
	}
	
	@Override
	public JButton getButton(int i){
		return buttons[i];
	}

	@Override
	public int getNumOfButton() {
		return 2;
	}
}
