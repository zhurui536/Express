package main.presentation.storeui.tool;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class CheckTool extends JPanel implements GetButtonOfTool{
	private JButton buttons[] = new JButton[2];
	private JTextArea startt;
	private JTextArea endt;
	
	public CheckTool(ToolListener tl){
		this.setName("check");
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		
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
		
		JLabel starttime = new JLabel("起始时间：");
		starttime.setSize(80, 40);
		starttime.setLocation(145, 35);
		this.add(starttime);
		
		startt = new JTextArea();
		startt.setSize(100, 40);
		startt.setLocation(235, 35);
		this.add(startt);
		
		JLabel endtime = new JLabel("终止时间：");
		endtime.setSize(80, 40);
		endtime.setLocation(355, 35);
		this.add(endtime);
		
		endt = new JTextArea();
		endt.setSize(100, 40);
		endt.setLocation(445, 35);
		this.add(endt);
	}
	
	@Override
	public JButton getButton(int i){
		return buttons[i];
	}
	
	public String getText(){
		return startt.getText()+" "+endt.getText();
	}
}
