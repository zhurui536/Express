package presentation.mainui.component;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.UIImage;

public class MyTool extends JPanel {
	private ToolButton[] buttons;
	
	public MyTool(String[] buttonname, ActionListener listener){
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		JLabel bg = new JLabel();
		bg.setIcon(UIImage.BACKGROUND_TOOL);
		bg.setBounds(0, 0, 1000, 100);
		this.add(bg, -1);
		
		buttons = new ToolButton[buttonname.length];
		for(int i=0;i<buttonname.length;i++){
			buttons[i] = new ToolButton(150+125*i, 40, buttonname[i]);
			buttons[i].addActionListener(listener);
			this.add(buttons[i], 0);
		}
	}
	
	public JButton getButton(int i){
		return buttons[i];
	}

	public int getNumOfButton() {
		return buttons.length;
	}
}
