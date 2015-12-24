package presentation.mainui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolPane extends JPanel {
	protected JButton buttons[];
	
	public ToolPane(){
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
		this.setBackground(Color.BLUE);
	}
	
	public JButton getButton(int i){
		return buttons[i];
	}

	public int getNumOfButton() {
		return buttons.length;
	}
}
