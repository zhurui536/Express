package presentation.storeui.tool;

import presentation.storeui.listener.ToolListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class AdjustTool extends JPanel implements GetButtonOfTool{
	private JButton buttons[] = new JButton[3];
	
	public AdjustTool(ToolListener tl){
		this.setName("adjust");
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		
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
	
	@Override
	public JButton getButton(int i){
		return buttons[i];
	}

	@Override
	public int getNumOfButton() {
		return 3;
	}
}
