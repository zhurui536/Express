package presentation.storeui.tool;

import javax.swing.JButton;
import javax.swing.JTextArea;

import presentation.ToolPane;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class CheckTool extends ToolPane{
	private JTextArea startt;
	private JTextArea endt;
	
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
	
	public String getText(){
		return startt.getText()+" "+endt.getText();
	}
}
