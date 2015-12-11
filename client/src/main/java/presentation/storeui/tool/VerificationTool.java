package presentation.storeui.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;

import presentation.ToolPane;
import presentation.storeui.listener.ToolListener;

@SuppressWarnings("serial")
public class VerificationTool extends ToolPane{
	private JButton buttons[] = new JButton[2];
	
	public VerificationTool(ToolListener tl){
		super.buttons = new JButton[2];
		
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
		
		JLabel batch = new JLabel(df.format(Calendar.getInstance().getTime()));
		batch.setSize(150, 60);
		batch.setLocation(145, 30);
		this.add(batch);
	}
	
	private final SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
}
