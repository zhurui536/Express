package main.presentation.storeui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import main.presentation.storeui.listener.toollistener.AdjustToolListener;

public class AdjustInputFrame extends JFrame implements ActionListener {
	//确定、取消按钮
	private JButton confirm, cancle;
	//起始位置的输入框
	private JTextArea[] startplace;
	//终止位置的输入框
	private JTextArea[] endplace;
	//输入的提示框
	private JLabel[] list;
	//输入窗口的标题
	private JLabel title;
	//上一级的监听者，处理输入
	AdjustToolListener listener;
	
	public AdjustInputFrame(AdjustToolListener listener){
		this.listener = listener;
		this.setName("入库货物输入");
		this.setLayout(null);
		this.setSize(430, 275);
		this.setLocation(400, 250);
		
		initialize();
	}
	
	public void initialize(){
		title = new JLabel("货物调整输入");
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
		
		list = new JLabel[2];
		for(int i=0;i<2;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setSize(70, 30);
			list[i].setLocation(15, 50+40*i);
			this.getContentPane().add(list[i]);
		}
		
		startplace = new JTextArea[4];
		for(int i=0;i<4;i++){
			startplace[i] = new JTextArea();
			startplace[i].setSize(45, 30);
			startplace[i].setLocation(110+55*i, 50);
			this.getContentPane().add(startplace[i]);
		}
		
		endplace = new JTextArea[4];
		for(int i=0;i<4;i++){
			endplace[i] = new JTextArea();
			endplace[i].setSize(45, 30);
			endplace[i].setLocation(110+55*i, 90);
			this.getContentPane().add(endplace[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancle){
			this.setVisible(false);
		}
		if(e.getSource() == confirm){
			try{
				int[] startplace = new int[4];
				int[] endplace = new int[4];
				
				for(int i=0;i<4;i++){
					startplace[i] = Integer.parseInt(this.startplace[i].getText()) - 1;
					endplace[i] = Integer.parseInt(this.endplace[i].getText()) - 1;
				}
				
				boolean result = listener.getInput(startplace, endplace);
				if(result){
					this.setVisible(false);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				System.out.println("input is wrong!");
			}
			//如果输入无法进行转换，那么将输入框重置
			for(int i=0;i<4;i++){
				this.startplace[i].setText("");
				this.endplace[i].setText("");
			}
			this.validate();
			this.repaint();
		}
	}
	
	private final String[] listname = {"起始位置：", "目标位置："};
}
