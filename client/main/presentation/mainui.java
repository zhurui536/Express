package main.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import main.presentation.managerui.ManagerFrame;
import main.presentation.storeui.StoreFrame;

/**
 * Created by Away
 * 2015/10/26
 */

@SuppressWarnings("serial")
public class mainui extends JFrame implements ActionListener{
	private JTextArea id;
	private JTextArea password;
	private JButton confirm;
	private JButton exit;
	
	public static void main(String[] args){
		mainui ui = new mainui();
		ui.setVisible(true);
	}
	
	public mainui(){
		this.setLayout(null);
		this.setBounds(300, 300, 310, 240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.initialize();
	}
	
	private void initialize(){
		JLabel title = new JLabel("用户登录");
		title.setBounds(120, 10, 100, 35);
		this.getContentPane().add(title);
		
		JLabel id = new JLabel("账号：");
		id.setBounds(20, 50, 50, 40);
		this.getContentPane().add(id);
		
		JLabel password = new JLabel("密码：");
		password.setBounds(20, 100, 50, 40);
		this.getContentPane().add(password);
		
		this.id = new JTextArea();
		this.id.setBounds(90, 50, 200, 40);
		this.getContentPane().add(this.id);
		
		this.password = new JTextArea();
		this.password.setBounds(90, 100, 200, 40);
		this.getContentPane().add(this.password);
		
		confirm = new JButton("登录");
		confirm.setBounds(40, 160, 80, 30);
		confirm.addActionListener(this);
		this.getContentPane().add(confirm);
		
		exit = new JButton("退出");
		exit.setBounds(150, 160, 80, 30);
		exit.addActionListener(this);
		this.getContentPane().add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			this.setVisible(false);
			System.exit(0);
		}
		if(e.getSource() == confirm){
			String id = this.id.getText();
			//根据id进行画面跳转
			if(id.charAt(0) == '0'){
				this.setVisible(false);
				StoreFrame frame = new StoreFrame();
				frame.setVisible(true);
			}
			if(id.charAt(0) == '1'){
				this.setVisible(false);
				ManagerFrame frame = new ManagerFrame();
				frame.setVisible(true);
			}
		}
	}
}
