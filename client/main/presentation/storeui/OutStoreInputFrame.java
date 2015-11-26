package main.presentation.storeui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class OutStoreInputFrame extends JFrame {
	private JButton confirm, cancle;
	private JTextArea number, destination;
	private JComboBox<String> trans;
	
	private JLabel[] list;
	private JLabel title;
	
	public static void main(String[] args){
		OutStoreInputFrame test = new OutStoreInputFrame();
		test.setVisible(true);
	}
	
	public OutStoreInputFrame(){
		this.setName("出库货物输入");
		this.setLayout(null);
		this.setSize(430, 275);
		this.setLocation(400, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialize();
	}
	
	private void initialize(){
		title = new JLabel("出库货物输入");
		title.setSize(90, 30);
		title.setLocation(170, 10);
		this.getContentPane().add(title);
		
		confirm = new JButton("确定");
		cancle = new JButton("取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.setLocation(250, 190);
		cancle.setLocation(330, 190);
		this.getContentPane().add(confirm);
		this.getContentPane().add(cancle);
		
		list = new JLabel[3];
		for(int i=0;i<3;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setSize(70, 30);
			list[i].setLocation(15, 50+40*i);
			this.getContentPane().add(list[i]);
		}
		
		number = new JTextArea();
		number.setSize(260, 30);
		number.setLocation(110, 50);
		this.getContentPane().add(number);
		
		destination = new JTextArea();
		destination.setSize(260, 30);
		destination.setLocation(110, 130);
		this.getContentPane().add(destination);
		
		trans = new JComboBox<String>();
		for(int i=0;i<transport.length;i++){
			trans.addItem(transport[i]);
		}
		trans.setSize(70, 30);
		trans.setLocation(110, 90);
		this.getContentPane().add(trans);
	}
	
	private final String[] listname = {"货物编号：", "装运方式", "目的地："};
	private final String[] transport = {"飞机", "火车", "货车"};
}
