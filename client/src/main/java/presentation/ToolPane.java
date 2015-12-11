package presentation;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolPane extends JPanel {
	protected JButton buttons[] = new JButton[3];
	
	public ToolPane(){
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setLocation(0, 0);
	}
	
	public JButton getButton(int i){
		return buttons[i];
	}

	public int getNumOfButton() {
		return buttons.length;
	}
}
