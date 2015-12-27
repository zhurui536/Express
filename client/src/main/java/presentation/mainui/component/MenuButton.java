package presentation.mainui.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import util.MyFont;
import util.UIImage;

@SuppressWarnings("serial")
public class MenuButton extends JButton  implements MouseListener{
	private boolean ifClicked;
	private JLabel text;
	private JLabel bg;
	
	public MenuButton(int x, int y, String text){
		this.setLayout(null);
		this.setBounds(x, y, 140, 50);
		this.addMouseListener(this);
		this.setContentAreaFilled(false);
		
		this.text = new JLabel(text, JLabel.CENTER);
		this.text.setFont(MyFont.getFont1());
		this.text.setBounds(0, 0, 140, 50);
		this.add(this.text, 0);
		ifClicked = false;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(!ifClicked){
			bg = new JLabel();
			bg.setBounds(0, 0, 140, 50);
			bg.setIcon(UIImage.BUTTON_OVER);
			this.add(bg, -1);
		}
	}
	
	public void unclicked(){
		if(ifClicked){
			ifClicked = false;
			this.remove(bg);
		}
	}
	
	public void clicked(){
		ifClicked = true;
		this.remove(bg);
		bg = new JLabel();
		bg.setBounds(0, 0, 140, 50);
		bg.setIcon(UIImage.BUTTON_CLICKED);
		this.add(bg, -1);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(!ifClicked){
			this.remove(bg);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
}
