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
	
	private int w = 125;
	private int h = 60;
	
	public ToolButton(int x, int y, String text){
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.addMouseListener(this);
		this.setContentAreaFilled(false);
		
		this.text = new JLabel(text, JLabel.CENTER);
		this.text.setBounds(0,  0, w, h);
		this.add(this.text, 0);
		bg = new JLabel();
		bg.setBounds(0, 0, w, h);
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
			this.remove(bg);
			bg = new JLabel();
			bg.setBounds(0, 0, w, h);
			bg.setIcon(UIImage.TOOLBUTTON_OVER);
			this.add(bg, -1);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(!ifClicked){
			this.remove(bg);
			bg = new JLabel();
			bg.setBounds(0, 0, w, h);
			bg.setIcon(UIImage.TOOLBUTTON);
			this.add(bg, -1);
		}
	}
	
	public void unclicked(){
		ifClicked = false;
		this.setContentAreaFilled(false);
		bg = new JLabel();
		bg.setBounds(0, 0, w, h);
		bg.setIcon(UIImage.TOOLBUTTON);
		this.add(bg, -1);
	}
	
	public void clicked(){
		ifClicked = true;
		this.remove(bg);
	}
	
	public void setSize(int w, int h){
		this.w = w;
		this.h = h;
		bg.setBounds(0, 0, w, h);
		text.setBounds(0, 0, w, h);
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
