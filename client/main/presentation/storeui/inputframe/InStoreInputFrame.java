package main.presentation.storeui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import main.presentation.storeui.listener.toollistener.InStoreToolListener;

@SuppressWarnings("serial")
public class InStoreInputFrame extends JFrame implements ActionListener{
	private JButton confirm, cancle;
	private JTextArea number, destination;
	private JTextArea[] place;
	private JLabel[] list;
	private JLabel title;
	
	//上一级的窗口并不是监听者，而是动作的执行者
	private InStoreToolListener listener;
	
	public InStoreInputFrame(InStoreToolListener listener){
		this.setName("入库货物输入");
		this.setLayout(null);
		this.setSize(430, 275);
		this.setLocation(400, 250);
		this.listener = listener;
		initialize();
	}
	
	//设置按钮的同时将自身作为监听者
	private void initialize(){
		title = new JLabel("入库货物输入");
		title.setSize(90, 30);
		title.setLocation(170, 10);
		this.getContentPane().add(title);
		
		confirm = new JButton("确定");
		cancle = new JButton("取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.setLocation(250, 190);
		cancle.setLocation(330, 190);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
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
		
		place = new JTextArea[4];
		for(int i=0;i<4;i++){
			place[i] = new JTextArea();
			place[i].setSize(45, 30);
			place[i].setLocation(110+55*i, 90);
			this.getContentPane().add(place[i]);
		}
		
	}
	
	private final String[] listname = {"货物编号：", "存储位置：", "目的地："};

	@Override
	public void actionPerformed(ActionEvent e) {
		//将输入委托给上一级进行处理
		if(e.getSource() == confirm){
			String number = this.number.getText();
			String destination = this.destination.getText();
			int[] place = new int[4];
			
			for(int i=0;i<4;i++){
				place[i] = Integer.parseInt(this.place[i].getText()) - 1;
			}
			
			boolean result = listener.getInput(number, destination, place);
			if(result){
				this.setVisible(false);
			}
			else{
				//提示输入错误或者网络错误
			}
		}
		else if(e.getSource() == cancle){
			this.setVisible(false);
		}
		
	}
}
