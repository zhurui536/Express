package presentation.mainui.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import util.UIImage;

public class ToolButton extends JButton  implements MouseListener{
	private boolean ifClicked;
	private JLabel bg;
	private JLabel text;
	
	public ToolButton(int x, int y, String text){
		this.setLayout(null);
		this.setBounds(x, y, 125, 60);
		this.addMouseListener(this);
		this.setContentAreaFilled(false);
		
		this.text = new JLabel(text, JLabel.CENTER);
		this.text.setBounds(0,  0, 125, 60);
		this.add(this.text, 0);
		bg = new JLabel();
		bg.setBounds(0, 0, 125, 60);
		bg.setIcon(UIImage.TOOLBUTTON);
		this.add(bg, -1);
		ifClicked = false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(!ifClicked){
			bg = new JLabel();
			bg.setBounds(0, 0, 125, 60);
			bg.setIcon(UIImage.TOOLBUTTON_OVER);
			this.add(bg, -1);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(!ifClicked){
			bg = new JLabel();
			bg.setBounds(0, 0, 125, 60);
			bg.setIcon(UIImage.TOOLBUTTON);
			this.add(bg, -1);
		}
	}
	
	public void unclicked(){
		ifClicked = false;
		this.setContentAreaFilled(false);
		bg = new JLabel();
		bg.setBounds(0, 0, 125, 60);
		bg.setIcon(UIImage.TOOLBUTTON);
		this.add(bg, -1);
	}
	
	public void clicked(){
		ifClicked = true;
		this.remove(bg);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}