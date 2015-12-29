package presentation.mainui.component;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.UIImage;

@SuppressWarnings("serial")
public class MyTool extends JPanel {
	
	private ToolButton[] buttons;
	
	private JLabel buttonExit;
	
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
		
		initExitButton();
	}
	
	private void initExitButton() {
		buttonExit = new JLabel(UIImage.EXIT_DARK);
		buttonExit.setBounds(950, 0, 50, 50);
		buttonExit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				buttonExit.setIcon(UIImage.EXIT_LIGHT);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				buttonExit.setIcon(UIImage.EXIT_DARK);
			}
			
		});
		this.add(buttonExit, 0);
	}

	public JButton getButton(int i){
		return buttons[i];
	}

	public int getNumOfButton() {
		return buttons.length;
	}
}
