package presentation.storeui.tool;

import presentation.storeui.listener.ToolListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class InStoreTool extends JPanel implements GetButtonOfTool{
	private JButton buttons[] = new JButton[3];
	
	public InStoreTool(ToolListener tl){
		this.setName("instore");
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		
		buttons[0] = new JButton("新建入库项");
		buttons[0].setSize(105, 25);
		buttons[0].setLocation(145, 40);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1]= new JButton("确定");
		buttons[1].setSize(100, 30);
		buttons[1].setLocation(770, 35);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2] = new JButton("取消入库");
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