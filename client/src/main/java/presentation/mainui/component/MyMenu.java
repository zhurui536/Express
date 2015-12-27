package presentation.mainui.component;

import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.UIImage;

public class MyMenu extends JPanel {
	public MenuButton[] buttons;
	
	public MyMenu(String[] buttonname, ActionListener listener){
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(140, 500);
		this.setLocation(0, 100);
		JLabel bg = new JLabel();
		bg.setIcon(UIImage.BACKGROUND_MENU);
		bg.setBounds(0, 0, 140, 500);
		this.add(bg, -1);
		
		buttons = new MenuButton[buttonname.length];
		for(int i=0;i<buttonname.length;i++){
			buttons[i] = new MenuButton(0, 20+50*i, buttonname[i]);
			buttons[i].addActionListener(listener);
			this.add(buttons[i], 0);
		}
	}
	
	public void refreshButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].unclicked();
	}
}
